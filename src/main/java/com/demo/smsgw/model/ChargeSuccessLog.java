/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.smsgw.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "charge_success_log")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChargeSuccessLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    @Column(name = "msisdn")
    private String msisdn;

    @Basic(optional = false)
    @Column(name = "amount")
    private int amount;

    @Basic(optional = false)
    @Column(name = "amount_with_vat")
    private float amountWithVat;

    @Basic(optional = false)
    @Column(name = "validity")
    private int validity;

    @Basic(optional = false)
    @Column(name = "ins_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insDate;

    @Basic(optional = false)
    @Column(name = "tid_ref")
    private String tidRef;

    @Basic(optional = false)
    @Column(name = "response")
    private String response;

    @JoinColumn(name = "charge_id", referencedColumnName = "id")
    @ManyToOne
    private ChargeConf chargeId;

    @JoinColumn(name = "sms_id", referencedColumnName = "id")
    @ManyToOne
    private Inbox smsId;

    @JoinColumn(name = "keyword_id", referencedColumnName = "id")
    @ManyToOne
    private KeywordDetails keywordId;

}
