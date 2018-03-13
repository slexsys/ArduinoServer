package com.server.devices.jpa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "devicesTasks")
public class DeviceTask implements Serializable {
    //region fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //@Id
    @ManyToOne
    @JoinColumn(name = "deviceId")
    private Device device;
    private Long subDeviceId;

    //@Id
    @ManyToOne
    @JoinColumn(name = "taskId")
    private Task task;

    @Temporal(TemporalType.TIMESTAMP)
    private Date taskDate;
    private Long duration;
    private Long done;

    //@Id
    @ManyToOne
    @JoinColumn(name = "statusId")
    private TaskStatus status;
    //endregion

    //region constructors
    public DeviceTask() {
    }
    //endregion

    //region getters setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Long getSubDeviceId() {
        return subDeviceId;
    }

    public void setSubDeviceId(Long subDeviceId) {
        this.subDeviceId = subDeviceId;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Date getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(Date taskDate) {
        this.taskDate = taskDate;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getDone() {
        return done;
    }

    public void setDone(Long done) {
        this.done = done;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
    //endregion

    //region overrides
    @Override
    public String toString() {
        return "DeviceTask{" +
                "id=" + id +
                ", deviceId=" + device.getId() +
                ", subDeviceId=" + subDeviceId +
                ", task=" + task.getName() +
                ", taskDate=" + taskDate +
                ", duration=" + duration +
                ", done=" + done +
                ", status=" + status.getName() +
                '}';
    }
    //endregion
}
