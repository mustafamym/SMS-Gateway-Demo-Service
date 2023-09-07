/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.smsgw.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "outbox")
@Data
public class Outbox implements Serializable {

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
    @Column(name = "ins_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insDate;
    @Basic(optional = false)
    @Column(name = "sms_text")
    private String smsText;
    @Basic(optional = false)
    @Column(name = "reply_addr")
    private String replyAddr;
    @Basic(optional = false)
    @Column(name = "status")
    private Character status;
    @Column(name = "send_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sendDate;

//    @JoinColumn(name = "sms_id", referencedColumnName = "id")
//    @ManyToOne(optional = false)
//    private Inbox smsId;

}
