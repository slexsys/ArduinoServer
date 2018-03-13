package com.server.devices.web.rest.api;

import com.server.devices.jpa.adapter.ArduinoSTD;
import com.server.devices.jpa.adapter.ArduinoTask;
import com.server.devices.jpa.adapter.ArduinoTasks;
import com.server.devices.jpa.model.*;
import com.server.devices.jpa.repository.DeviceRepository;
import com.server.devices.jpa.repository.DeviceTaskRepository;
import com.server.devices.jpa.repository.LogTypeRepository;
import com.server.devices.jpa.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    DeviceTaskRepository deviceTaskRepository;

    @Autowired
    LogTypeRepository logTypeRepository;

    @Autowired
    LogRepository logsRepository;

    @RequestMapping(value = "/date")
    public String getTask() {
        Date date = new Date();
        return Long.toString(ArduinoSTD.getDate(date.getTime()));
    }

    @RequestMapping(value = "/tasks/{id}")
    public String getTask(@PathVariable("id") long id) {
        Date date = new Date();
        List<DeviceTask> list = deviceTaskRepository.findDeviceTaskByDeviceIdAndTaskDateAndTaskStatus(id, TaskStatusEnum.Ready);//, date);
        ArduinoTasks tasks = ArduinoTasks.fromDeviceTaskList(list);
        return tasks.toString();
    }

    @RequestMapping(value = "/tasks/{id}/{ids}")
    public String getTask(@PathVariable("id") long id, @PathVariable("ids") String ids) {
        //System.out.println("from id: " + id + " ids : " + ids + " received.");
        String[] array = ids.split(ArduinoTask.SEPARATOR);
        List<Long> listIds = new ArrayList<>();
        for (String item : array) {
            listIds.add(Long.parseLong(item));
        }

        System.out.println("List of ids" + listIds);
        List<DeviceTask> list = deviceTaskRepository.findDeviceTaskByTaskStatus(listIds);
        ArduinoTasks tasks = ArduinoTasks.fromDeviceTaskList(list);
        return tasks.toString();
    }

    @RequestMapping(value = "/task/done/{id}")
    public String taskDone(@PathVariable("id") long id) {
        deviceTaskRepository.taskUpdate(id, TaskStatusEnum.Done.getId());
        return "ok";
    }

    @RequestMapping(value = "/task/updated/{id}")
    public String taskUpdated(@PathVariable("id") long id) {
        deviceTaskRepository.taskUpdate(id, TaskStatusEnum.Ready.getId());
        return "ok";
    }

    @RequestMapping(value = "/task/update", params = {"deviceId", "taskId", "interval"})
    public String taskStepUpdate(@RequestParam("deviceId") long deviceId,
                                 @RequestParam("taskId") long taskId,
                                 @RequestParam("interval") long interval) {

        deviceTaskRepository.taskUpdateDoneAndStatus(taskId, TaskStatusEnum.Do.getId(), interval);

        System.out.println("Task interval update client: " + deviceId + ", taskId: " + taskId + ", interval:" + interval);
        return "ok";
    }

    @RequestMapping(value = "/device/log", params = {"deviceId", "logId", "text"})
    public String deviceLogger(@RequestParam("deviceId") long deviceId,
                                 @RequestParam("logId") long logId,
                                 @RequestParam("text") String text) {

        Date date = new Date();
        LogType logType = logTypeRepository.findOne(logId);
        Device device = deviceRepository.findOne(deviceId);
        Log log = new Log(logType, device, date, text);

        logsRepository.save(log);

        System.out.println(log.toString());
        return "ok";
    }
}
