package com.demo.smsgw.service;

import com.demo.smsgw.dto.ChargeFailLogDto;
import com.demo.smsgw.model.ChargeFailLog;
import com.demo.smsgw.repository.ChargeFailLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChargeFailLogServiceImpl implements ChargeFailLogService {
    private final ChargeFailLogRepository chargeFailLogRepository;

    @Override
    public void savedChargeFailLog(ChargeFailLog chargeFailLog) {
        chargeFailLogRepository.save(chargeFailLog);
    }

    @Override
    public Page<ChargeFailLog> getChargeFailLog(Integer currentPage, Integer pageSize) {
        Pageable pageable = PageRequest.of(currentPage, pageSize);
       return chargeFailLogRepository.findAll(pageable);

    }
}
