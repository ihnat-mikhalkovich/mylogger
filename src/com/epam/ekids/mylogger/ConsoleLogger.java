package com.epam.ekids.mylogger;

import java.time.LocalDateTime;

public class ConsoleLogger {

    // trace, debug, info, warn, error
    private Level logLevel = Level.DEBUG;

    private Class clazz;

    public ConsoleLogger(Class clazz) {
        this.clazz = clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public void setLogLevel(Level logLevel) {
        this.logLevel = logLevel;
    }

    public void trace(String text) {
        log(text, Level.TRACE);
    }

    public void debug(String text) {
        log(text, Level.DEBUG);
    }

    public void info(String text) {
        log(text, Level.INFO);
    }

    public void warn(String text) {
        log(text, Level.WARN);
    }

    public void error(String text) {
        log(text, Level.ERROR);
    }

    public void log(String text, Level level) {
        if (!(logLevel.ordinal() > level.ordinal())) {
            System.out.println(LocalDateTime.now().toString() + " " + level + " " + clazz + " " +": " + text);
        }
    }
}