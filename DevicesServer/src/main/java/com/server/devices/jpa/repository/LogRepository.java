package com.server.devices.jpa.repository;

import com.server.devices.jpa.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface LogRepository extends JpaRepository<Log, Long> {
    /*@Modifying
    @Query("")
    @Transactional
    void taskUpdateDoneAndStatus(@Param("id") long id,
                                 @Param("statusId") long statusId,
                                 @Param("interval") long interval);/**/
}
