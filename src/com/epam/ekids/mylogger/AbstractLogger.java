package com.epam.ekids.mylogger;

public abstract class AbstractLogger implements Logger {

    // trace, debug, info, warn, error
    protected Level logLevel = Level.DEBUG;

    protected Class clazz;

    public AbstractLogger(Class clazz) {
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
        if (logLevel.ordinal() > level.ordinal()) {
            return;
        }
        process(text, level);
    }

    protected abstract void process(String text, Level level);
}
