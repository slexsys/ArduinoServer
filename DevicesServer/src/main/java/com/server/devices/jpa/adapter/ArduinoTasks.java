package com.server.devices.jpa.adapter;

import com.server.devices.jpa.model.DeviceTask;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

public class ArduinoTasks extends LinkedList<ArduinoTask> {
    //region finals
    public static final String SEPARATOR = "#";
    //endregion

    //region public methods
    public static ArduinoTasks fromDeviceTaskList(List<DeviceTask> list) {
        ArduinoTasks tasks = new ArduinoTasks();
        for (DeviceTask task : list) {
            ArduinoTask atask = ArduinoTask.fromDeviceTask(task);
            tasks.add(atask);
        }
        return tasks;
    }
    //endregion

    //region override
    @Override
    public String toString() {
        List<String> list = new ArrayList<>();
        for(ArduinoTask task : this) {
            list.add(task.toString());
        }
        return String.join(SEPARATOR, list);
    }
    //endregion
}
