package com.demo.smsgw.service;

import com.demo.smsgw.dto.ChargeSuccessLogDto;
import com.demo.smsgw.model.ChargeSuccessLog;
import com.demo.smsgw.repository.ChargeSuccessLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChargeSuccessLogServiceImpl implements ChargeSuccessLogService {
    private final ChargeSuccessLogRepository chargeSuccessLogRepository;

    @Override
    public void saveChargeSuccessLog(ChargeSuccessLog chargeSuccessLog) {
        chargeSuccessLogRepository.save(chargeSuccessLog);

    }

    @Override
    public Page<ChargeSuccessLog> getAllChargeSuccessLog(Integer currentPage, Integer pageSize) {
        Pageable pageable = PageRequest.of(currentPage, pageSize);
       return chargeSuccessLogRepository.findAll(pageable);
    }
}
