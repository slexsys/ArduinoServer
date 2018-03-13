package com.server.devices.jpa.model;

public enum LogTypeEnum {
    //region values
    Info (1),
    Debug (2),
    Error (3);
    //endregion

    //region fields
    private long id;
    //endregion

    //region constructors
    LogTypeEnum(long id) {
        this.id = id;
    }
    //endregion

    //region getters
    public long getId() {
        return id;
    }
    //endregion
}
