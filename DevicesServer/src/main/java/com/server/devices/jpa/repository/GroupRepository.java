package com.server.devices.jpa.repository;

import com.server.devices.jpa.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
