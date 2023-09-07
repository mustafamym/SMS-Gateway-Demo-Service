package com.demo.smsgw.connector;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "gp-moMagic-service", url = "https://gb.gp.momagic.com.bd")
public interface GpMoMagicFeignClient {

    @GetMapping("/unloc-code/test")
    String callUnlockCode(@RequestParam("msg") String message);


    @GetMapping("/charge/test")
    String chargingRequest(@RequestParam("charge_code") String chargeCode, @RequestParam("msisdn") String msisdn);


}