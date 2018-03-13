package com.server.devices.jpa.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tasks")
public class Task {
    //region fields
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "task")
    private Set<DeviceTask> deviceTasks;
    //endregion

    //region constructors
    public Task() {
    }

    public Task(Long id, String name) {
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

    //region overrides
    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    //endregion
}
