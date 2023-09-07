/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.smsgw.dto;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChargeSuccessLogDto implements Serializable {


    private Long id;

    private String msisdn;

    private int amount;

    private float amountWithVat;

    private int validity;

    @Temporal(TemporalType.TIMESTAMP)
    private Date insDate;

    private String tidRef;

    private String response;


}
