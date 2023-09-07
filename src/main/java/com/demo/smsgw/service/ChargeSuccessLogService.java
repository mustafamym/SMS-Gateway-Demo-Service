package com.demo.smsgw.service;

import com.demo.smsgw.dto.ChargeSuccessLogDto;
import com.demo.smsgw.model.ChargeSuccessLog;
import org.springframework.data.domain.Page;

public interface ChargeSuccessLogService {
    void saveChargeSuccessLog(ChargeSuccessLog chargeSuccessLog);

    Page<ChargeSuccessLog> getAllChargeSuccessLog(Integer currentPage, Integer pageSize);
}
