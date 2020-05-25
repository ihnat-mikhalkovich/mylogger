package com.epam.ekids.mylogger;

public class ConsoleLogger {

    // trace, debug, info, warn, error
    private Level logLevel = Level.DEBUG;

    public void setLogLevel(Level logLevel) {
        this.logLevel = logLevel;
    }

    public void trace(String text) {
        if (!(logLevel.ordinal() > Level.TRACE.ordinal())) {
            System.out.println("trace: " + text);
        }
    }

    public void debug(String text) {
        if (!(logLevel.ordinal() > Level.DEBUG.ordinal())) {
            System.out.println("debug: " + text);
        }
    }

    public void info(String text) {
        if (!(logLevel.ordinal() > Level.INFO.ordinal())) {
            System.out.println("info: " + text);
        }
    }

    public void warn(String text) {
        if (!(logLevel.ordinal() > Level.WARN.ordinal())) {
            System.out.println("warn: " + text);
        }
    }

    public void error(String text) {
        if (!(logLevel.ordinal() > Level.ERROR.ordinal())) {
            System.out.println("error: " + text);
        }
    }
}