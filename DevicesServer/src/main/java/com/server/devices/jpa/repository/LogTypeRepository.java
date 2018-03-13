package com.server.devices.jpa.repository;

import com.server.devices.jpa.model.LogType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogTypeRepository extends JpaRepository<LogType, Long> {
}
