package com.server.devices;

import com.server.devices.jpa.model.*;
import com.server.devices.jpa.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class DevicesApplication {
	@Autowired
	GroupRepository groupRepository;

	@Autowired
	DeviceRepository deviceRepository;

	@Autowired
	TaskRepository taskRepository;

	@Autowired
	TaskStatusRepository taskStatusRepository;

	@Autowired
	DeviceTaskRepository deviceTaskRepository;

	@Autowired
	LogTypeRepository logTypeRepository;

	private static final Logger log = LoggerFactory.getLogger(SpringApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DevicesApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo() {
		return (args) -> {
			addTestData();
			testDeviceTask(5, 1, new Date(), 60);
			testDeviceTask(3, 1, new Date(), 400);
			testDeviceTask(5, 2, new Date(), 80);
			testDeviceTask(2, 2, new Date(), 800);
			testDeviceTask(6, 1, new Date(), 300);
		};
	}

	private void testDeviceTask(long devId, long subDevId, Date date, long duration) {
		Device d = deviceRepository.findOne(devId);
		Task t = taskRepository.findOne(3L);
		TaskStatus s = taskStatusRepository.findOne(1L);

		DeviceTask dt = new DeviceTask();
		dt.setDevice(d);
		dt.setSubDeviceId(subDevId);
		dt.setTask(t);
		dt.setStatus(s);
		dt.setTaskDate(date);
		dt.setDuration(duration);
		dt.setDone(0L);

		deviceTaskRepository.save(dt);
	}

	private void addTestData() {
		testGroup(groupRepository);
		testDevice(deviceRepository);
		testTask(taskRepository);
		testTaskStatus(taskStatusRepository);
		testLogType(logTypeRepository);
	}

	private void testGroup(GroupRepository repository) {
		Group g1 = new Group("g1");
		Group g11 = new Group("g11", g1);
		Group g12 = new Group("g12", g1);
		repository.save(g1);
		repository.save(g11);
		repository.save(g12);

		for(Group group : repository.findAll()) {
			log.info(group.toString());
		}
	}

	private void testDevice(DeviceRepository repository) {
		Group group1 = groupRepository.findOne(1L);
		repository.save(new Device("dev1", "m1-n1-d1", group1));
		repository.save(new Device("dev2", "m2-n2-d2", group1));
		repository.save(new Device("dev3", "m3-n3-d3", group1));

		Group group2 = groupRepository.findOne(2L);
		repository.save(new Device("dev4", "m4-n4-d4", group2));
		repository.save(new Device("dev5", "m5-n5-d5", group2));
		repository.save(new Device("dev6", "m6-n6-d6", group2));

		for(Device device : repository.findAll()) {
			log.info(device.toString());
		}
	}

	private void testTask(TaskRepository repository) {
		TaskEnum[] array = TaskEnum.values();
		for (TaskEnum item : array) {
			repository.save(new Task(item.getId(), item.name()));
		}

		for(Task task : repository.findAll()) {
			log.info(task.toString());
		}
	}

	private void testTaskStatus(TaskStatusRepository repository) {
		TaskStatusEnum[] array = TaskStatusEnum.values();
		for (TaskStatusEnum item : array) {
			repository.save(new TaskStatus(item.getId(), item.name()));
		}

		for(TaskStatus taskStatus : repository.findAll()) {
			log.info(taskStatus.toString());
		}
	}

	private void testLogType(LogTypeRepository repository) {
		LogTypeEnum[] array = LogTypeEnum.values();
		for (LogTypeEnum item : array) {
			repository.save(new LogType(item.getId(), item.name()));
		}

		for(LogType item : repository.findAll()) {
			log.info(item.toString());
		}
	}
}
