package com.demo.smsgw.service;

import com.demo.smsgw.dto.ChargeFailLogDto;
import com.demo.smsgw.model.ChargeFailLog;
import org.springframework.data.domain.Page;

public interface ChargeFailLogService {

    void savedChargeFailLog(ChargeFailLog chargeFailLog);

    Page<ChargeFailLog> getChargeFailLog(Integer currentPage, Integer pageSize);
}
