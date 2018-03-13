package com.server.devices.jpa.model;

public enum TaskEnum {
    On(1),
	Off(2),
	OnInTime(3);

    private long id;

    TaskEnum(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
