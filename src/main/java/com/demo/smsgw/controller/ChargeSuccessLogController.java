package com.demo.smsgw.controller;

import com.demo.smsgw.model.ChargeSuccessLog;
import com.demo.smsgw.service.ChargeSuccessLogService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api", produces = {"application/json"})
@Slf4j
@Validated
@AllArgsConstructor
public class ChargeSuccessLogController {
    private final ChargeSuccessLogService chargeSuccessLogService;

    @GetMapping("/chargeSuccessLogs")
    public ResponseEntity<Page<ChargeSuccessLog>> getAllBatchList(@RequestParam(value = "currentPage", required = false,
            defaultValue = "0") Integer currentPage,
                                                                  @RequestParam(value = "pageSize", required = false,
                                                                          defaultValue = "100") Integer pageSize) {
        return new ResponseEntity<>(chargeSuccessLogService.getAllChargeSuccessLog(currentPage, pageSize), HttpStatus.OK);
    }
}
