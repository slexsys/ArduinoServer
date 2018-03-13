package com.server.devices.jpa.repository;

import com.server.devices.jpa.model.DeviceTask;
import com.server.devices.jpa.model.TaskStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface DeviceTaskRepository extends JpaRepository<DeviceTask, Long> {
    @Query("SELECT o FROM DeviceTask o WHERE o.device.id = :#{#id} AND o.status.id = :#{#status.id}")
    List<DeviceTask> findDeviceTaskByDeviceIdAndTaskDateAndTaskStatus(@Param("id") long id, @Param("status")TaskStatusEnum status);

    @Query("SELECT o FROM DeviceTask o WHERE o.id in :ids")
    List<DeviceTask> findDeviceTaskByTaskStatus(@Param("ids") List<Long> ids);

    @Query("UPDATE DeviceTask o SET o.status.id = :statusId WHERE o.id = :id")
    @Modifying
    @Transactional
    void taskUpdate(@Param("id") long id, @Param("statusId") long statusId);

    //@Query("UPDATE DeviceTask o SET o.status.id = :statusId, o.done = o.done + :interval WHERE o.id = :id")
    @Query("UPDATE DeviceTask o SET o.status.id = :statusId, o.done = :interval WHERE o.id = :id")
    @Modifying
    @Transactional
    void taskUpdateDoneAndStatus(@Param("id") long id,
                                       @Param("statusId") long statusId,
                                       @Param("interval") long interval);
}

