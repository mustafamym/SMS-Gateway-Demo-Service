package com.demo.smsgw.service;

import com.demo.smsgw.connector.GpMoMagicFeignClient;
import com.demo.smsgw.model.*;
import com.demo.smsgw.repository.ChargeConfRepository;
import com.demo.smsgw.repository.InboxRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InboxServiceImpl implements InboxService {

    private final InboxRepository inboxRepository;
    private final KeywordDetailsService keywordDetailsService;
    private final GpMoMagicFeignClient gpMoMagicFeignClient;
    private final ChargeConfRepository chargeConfRepository;
    private final ChargeFailLogService chargeFailLogService;
    private final ChargeSuccessLogService chargeSuccessLogService;


    @Override
    public boolean findInboxByStatus(String status, Pageable pageable) {
        Page<Inbox> inboxMsg = inboxRepository.findAllByStatusIs(status, pageable);
        if (!inboxMsg.getContent().isEmpty()) {
            List<KeywordDetails> listOfKeywordDetails = keywordDetailsService.getAllKeywordDetails();
            if (listOfKeywordDetails.isEmpty()) {
                return false;
            }
            List<ChargeConf> chargeConfs = chargeConfRepository.findAll();
            if (chargeConfs.isEmpty()) {
                return false;
            }

            inboxMsg.getContent().forEach(inbox -> {
                Optional<KeywordDetails> keywordDetails = keywordMatching(listOfKeywordDetails, inbox);
                keywordDetails.ifPresent(keyword -> {
                    String getUnlockCode = getUnlockCode(inbox, keyword);
                    Optional<ChargeConf> chargeConf = getChargeConf(chargeConfs, getUnlockCode);
                    chargeConf.ifPresent(chargeConfig -> {
                        String chargingApiResponse = chargingRequest(chargeConfig, inbox);
                        String msgChargeStatus = savedSuccessFailLog(chargingApiResponse, inbox, keyword, chargeConfig);
                        inbox.setStatus(msgChargeStatus);
                        inboxRepository.save(inbox);

                    });
                });
            });
        }

        return true;
    }

    private Optional<KeywordDetails> keywordMatching(List<KeywordDetails> listOfKeywordDetails, Inbox inbox) {
        return listOfKeywordDetails.stream()
                .filter(keyword -> inbox.getSmsText().contains(keyword.getKeyword()))
                .findFirst();
    }

    private String getUnlockCode(Inbox inbox, KeywordDetails keywordDetails) {
        //keywordDetails can be future use
        String inputSmsText = inbox.getSmsText();
        String addPlusInputSmsText = inputSmsText.replace(" ", "+");

        return gpMoMagicFeignClient.callUnlockCode(addPlusInputSmsText);
    }

    private Optional<ChargeConf> getChargeConf(List<ChargeConf> chargeConfs, String chargeCodeValue) {
        String[] splitResponse = chargeCodeValue.split("::");
        String chargeAmount = splitResponse[1];

        Optional<ChargeConf> chargeConf = getChargeConf(chargeConfs, Integer.parseInt(chargeAmount));
        return chargeConf;

    }

    private String chargingRequest(ChargeConf chargeConf, Inbox inbox) {

        String getCode = chargeConf.getChargeCode();
        return gpMoMagicFeignClient.chargingRequest(getCode, inbox.getMsisdn());

    }

    private Optional<ChargeConf> getChargeConf(List<ChargeConf> chargeConfs, int chargeAmount) {
        return chargeConfs.stream()
                .filter(chargeConf -> chargeConf.getPrice() == chargeAmount)
                .findFirst();
    }

    private String savedSuccessFailLog(String chargingApiResponse, Inbox inbox,
                                       KeywordDetails keywordDetails,
                                       ChargeConf chargeConf) {

        String status;

        String[] splitResponse = chargingApiResponse.split("::");
        String successFailCode = splitResponse[0];
        String successFailCode1 = splitResponse[1];
        String successFailMessage = splitResponse[2];

        if (successFailMessage.contains("success")) {
            ChargeSuccessLog chargeSuccessLog = ChargeSuccessLog.builder()
                    .msisdn(inbox.getMsisdn())
                    .chargeId(chargeConf)
                    .keywordId(keywordDetails)
                    .amount(chargeConf.getPrice())
                    .smsId(inbox)
                    .insDate(new Date())
                    .tidRef("tidRef")
                    .response(chargingApiResponse)
                    .build();
            chargeSuccessLogService.saveChargeSuccessLog(chargeSuccessLog);
            status = "S";
        } else {
            ChargeFailLog chargeFailLog = ChargeFailLog.builder()
                    .smsId(inbox)
                    .chargeId(chargeConf)
                    .keywordId(chargeConf)
                    .failCode(Integer.parseInt(successFailCode1))
                    .amount(chargeConf.getPrice())
                    .msisdn(inbox.getMsisdn())
                    .insDate(new Date())
                    .tidRef("tidRef")
                    .response(chargingApiResponse)
                    .build();
            chargeFailLogService.savedChargeFailLog(chargeFailLog);
            status = "F";

        }
        return status;
    }
}
