package com.server.devices.jpa.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "taskStatus")
public class TaskStatus {
    //region fields
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "status")
    private Set<DeviceTask> deviceTasks;
    //endregion

    //region constructors
    public TaskStatus() {
    }

    public TaskStatus(Long id, String name) {
        this.id = id;
        this.name = name;
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

    public Set<DeviceTask> getDeviceTasks() {
        return deviceTasks;
    }

    public void setDeviceTasks(Set<DeviceTask> deviceTasks) {
        this.deviceTasks = deviceTasks;
    }
    //endregion

    //region override
    @Override
    public String toString() {
        return "TaskStatus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    //endregion
}
