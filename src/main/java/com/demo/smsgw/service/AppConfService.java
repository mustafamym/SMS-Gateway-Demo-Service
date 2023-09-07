package com.demo.smsgw.service;

import com.demo.smsgw.model.AppConf;

import java.util.List;

public interface AppConfService {
    List<AppConf> findAppConfByStatus(int status);
}
