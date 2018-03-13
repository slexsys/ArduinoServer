package com.server.devices.jpa.adapter;

import com.server.devices.jpa.model.DeviceTask;

public class ArduinoTask {
    //region finals
    public static final String SEPARATOR = ":";
    //endregion

    //region fields
    private long id;
    private long subId;
    private long taskId;
    private long taskDate;
    private long duration;
    private long status;
    //endregion

    //region getters setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSubId() {
        return subId;
    }

    public void setSubId(long subId) {
        this.subId = subId;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public long getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(long taskDate) {
        this.taskDate = taskDate;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }
    //endregion

    //region public methods
    public static ArduinoTask fromDeviceTask(DeviceTask task) {
        return new ArduinoTask(){{
            setId(task.getId());
            setSubId(task.getSubDeviceId());
            setTaskId(task.getTask().getId());
            setTaskDate(ArduinoSTD.getDate(task.getTaskDate().getTime()));
            setDuration(task.getDuration());
            setStatus(task.getStatus().getId());
        }};
    }
    //endregion

    //region override
    @Override
    public String toString() {
        return id + SEPARATOR +
                subId + SEPARATOR +
                taskId + SEPARATOR +
                taskDate + SEPARATOR +
                duration + SEPARATOR +
                status;
    }
    //endregion
}
