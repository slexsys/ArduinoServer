package com.server.devices.jpa.repository;

import com.server.devices.jpa.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskStatusRepository extends JpaRepository<TaskStatus, Long> {
}
