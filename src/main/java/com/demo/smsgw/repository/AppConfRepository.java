package com.demo.smsgw.repository;

import com.demo.smsgw.model.AppConf;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppConfRepository extends JpaRepository<AppConf, Integer> {

    List<AppConf> findAppConfByStatusIs(int status);

}

