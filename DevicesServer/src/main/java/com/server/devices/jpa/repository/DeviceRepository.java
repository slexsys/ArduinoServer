package com.server.devices.jpa.repository;

import com.server.devices.jpa.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}
