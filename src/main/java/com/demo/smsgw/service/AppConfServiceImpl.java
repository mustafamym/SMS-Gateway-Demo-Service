package com.demo.smsgw.service;

import com.demo.smsgw.model.AppConf;
import com.demo.smsgw.repository.AppConfRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppConfServiceImpl implements AppConfService {

    final private AppConfRepository appConfRepository;

    @Override
    public List<AppConf> findAppConfByStatus(int status) {
        List<AppConf> list = appConfRepository.findAppConfByStatusIs(status);
        return list;
    }
}
