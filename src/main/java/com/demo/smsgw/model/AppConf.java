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
@Table(name = "app_conf")
@Data
public class AppConf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "app_name")
    private String appName;

    @Basic(optional = false)
    @Column(name = "number_of_thread")
    private int numberOfThread;

    @Column(name = "number_of_row")
    private Integer numberOfRow;

    @Basic(optional = false)
    @Column(name = "status")
    private int status;

    @Basic(optional = false)
    @Column(name = "last_start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastStartTime;

    @Basic(optional = false)
    @Column(name = "last_stop_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastStopTime;

    @Basic(optional = false)
    @Column(name = "stop_by")
    private String stopBy;

    @Basic(optional = false)
    @Column(name = "data_reload")
    private int dataReload;

    @Basic(optional = false)
    @Column(name = "last_reload_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastReloadTime;
}
