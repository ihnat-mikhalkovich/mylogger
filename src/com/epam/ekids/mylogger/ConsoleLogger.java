package com.epam.ekids.mylogger;

public class ConsoleLogger {

    // trace, debug, info, warn, error
    private String logLevel = "debug";

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public void trace(String text) {
        if ("trace".equals(logLevel)) {
            System.out.println("trace: " + text);
        }
    }

    public void debug(String text) {
        if ("debug".equals(logLevel) || "trace".equals(logLevel)) {
            System.out.println("debug: " + text);
        }
    }

    public void info(String text) {
        if ("info".equals(logLevel) || "debug".equals(logLevel) || "trace".equals(logLevel)) {
            System.out.println("info: " + text);
        }
    }

    public void warn(String text) {
        if ("warn".equals(logLevel) || "info".equals(logLevel) || "debug".equals(logLevel) || "trace".equals(logLevel)) {
            System.out.println("warn: " + text);
        }
    }

    public void error(String text) {
        if ("error".equals(logLevel) || "warn".equals(logLevel) || "info".equals(logLevel) || "debug".equals(logLevel) || "trace".equals(logLevel)) {
            System.out.println("error: " + text);
        }
    }
}