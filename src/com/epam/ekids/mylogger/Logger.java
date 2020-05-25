package com.epam.ekids.mylogger;

public interface Logger {

    void setClazz(Class clazz);

    void setLogLevel(Level logLevel);

    void trace(String text);

    void debug(String text);

    void info(String text);

    void warn(String text);

    void error(String text);

    void log(String text, Level level);
}
