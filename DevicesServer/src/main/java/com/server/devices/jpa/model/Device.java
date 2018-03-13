package com.server.devices.jpa.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "devices")
public class Device {
    //region fields
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;
    private String mac;

    @ManyToOne
    @JoinColumn(name = "groupId")
    private Group group;

    @OneToMany(mappedBy = "device")
    private Set<DeviceTask> deviceTasks;

    @OneToMany(mappedBy = "device")
    private Set<Log> logs;
    //endregion

    //region constructors
    public Device() { }

    public Device(String name, String mac) {
        this.name = name;
        this.mac = mac;
    }

    public Device(String name, String mac, Group group) {
        this.name = name;
        this.mac = mac;
        this.group = group;
    }
    //endregion

    //region getters setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Set<DeviceTask> getDeviceTasks() {
        return deviceTasks;
    }

    public void setDeviceTasks(Set<DeviceTask> deviceTasks) {
        this.deviceTasks = deviceTasks;
    }

    public Set<Log> getLogs() {
        return logs;
    }

    public void setLogs(Set<Log> logs) {
        this.logs = logs;
    }
    //endregion

    //region override
    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mac='" + mac + '\'' +
                ", group=" + group +
                '}';
    }
    //endregion
}
