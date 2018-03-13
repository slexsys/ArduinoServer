package com.server.devices.jpa.repository;

import com.server.devices.jpa.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
