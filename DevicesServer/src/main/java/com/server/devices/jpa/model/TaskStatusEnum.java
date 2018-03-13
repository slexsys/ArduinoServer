package com.server.devices.jpa.model;

public enum TaskStatusEnum {
    Ready(1),
    Do(2),
    Done(3),
    Update(4),
    Pause(5),
    Abort(6);

    private long id;

    TaskStatusEnum(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
