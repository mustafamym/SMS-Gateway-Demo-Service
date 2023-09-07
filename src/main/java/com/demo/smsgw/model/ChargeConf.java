/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.smsgw.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "charge_conf")
@Data
public class ChargeConf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "charge_code")
    private String chargeCode;
    @Basic(optional = false)
    @Column(name = "price")
    private int price;
    @Basic(optional = false)
    @Column(name = "price_with_vat")
    private float priceWithVat;
    @Basic(optional = false)
    @Column(name = "validity")
    private int validity;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chargeId")
//    private Collection<ChargeSuccessLog> chargeSuccessLogCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "keywordId")
//    private Collection<ChargeFailLog> chargeFailLogCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chargeId")
//    private Collection<ChargeFailLog> chargeFailLogCollection1;
}
