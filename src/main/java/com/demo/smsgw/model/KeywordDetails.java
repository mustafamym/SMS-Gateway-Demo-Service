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
@Table(name = "keyword_details")
@Data
public class KeywordDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "keyword")
    private String keyword;
    @Basic(optional = false)
    @Column(name = "game_name")
    private String gameName;
    @Basic(optional = false)
    @Column(name = "sms_spliter")
    private String smsSpliter;
    @Basic(optional = false)
    @Column(name = "unlockurl")
    private String unlockurl;
    @Basic(optional = false)
    @Column(name = "unlockurl_response_splitter")
    private String unlockurlResponseSplitter;
    @Basic(optional = false)
    @Column(name = "unlock_sms")
    private String unlockSms;
    @Column(name = "chargeurl")
    private String chargeurl;
    @Basic(optional = false)
    @Column(name = "ins_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insDate;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "keywordId")
//    private Collection<ChargeSuccessLog> chargeSuccessLogCollection;

}
