package com.server.devices.jpa.adapter;

public class ArduinoSTD {

    //region static methods
    public static long getDate(long date) {
        return date / 1000;//(60 * 1000);
    }
    //endregion
}
