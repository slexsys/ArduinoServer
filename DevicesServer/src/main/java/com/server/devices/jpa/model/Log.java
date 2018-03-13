package com.server.devices.jpa.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "logs")
public class Log {
    //region fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "logTypeId")
    private LogType logType;

    @ManyToOne
    @JoinColumn(name = "deviceId")
    private Device device;

    private Date date;
    private String text;
    //endregion

    //region constructors
    public Log() { }

    public Log(LogType logType, Device device, Date date, String text) {
        this.logType = logType;
        this.device = device;
        this.date = date;
        this.text = text;
    }

    //endregion

    //region getters setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LogType getLogType() {
        return logType;
    }

    public void setLogType(LogType logType) {
        this.logType = logType;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    //endregion

    //region override
    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", logType=" + logType +
                ", device=" + device.getId() +
                ", date=" + date +
                ", text='" + text + '\'' +
                '}';
    }
    //endregion
}
