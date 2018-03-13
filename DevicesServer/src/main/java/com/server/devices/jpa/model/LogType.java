package com.server.devices.jpa.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class LogType {
    //region fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "logType", cascade = CascadeType.ALL)
    private Set<Log> logs;
    //endregion

    //region constructors
    public LogType() { }

    public LogType(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    //endregion

    //region getters setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Log> getLogs() {
        return logs;
    }

    public void setLogs(Set<Log> logs) {
        this.logs = logs;
    }
    //endregion

    //region override
    @Override
    public String toString() {
        return "LogType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    //endregion
}
