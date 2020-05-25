package com.epam.ekids.mylogger;

import com.epam.ekids.mylogger.exception.MyLoggerPropertyException;
import com.epam.ekids.mylogger.impl.ConsoleLogger;
import com.epam.ekids.mylogger.impl.FileLogger;
import com.epam.ekids.mylogger.impl.MultipleLogger;

public final class LoggerFactory {

    private static PropertiesManager manager = PropertiesManager.getInstance();

    private final static Level DEFAULT_LOG_LEVEL = Level.DEBUG;

    private LoggerFactory() {
    }

    public static Logger getLogger(Class clazz) {
        Level level = getLevel();
        return getLogger(clazz, level);
    }

    public static Logger getLogger(Class clazz, Level level) {
        if (!manager.containsKey(PropertiesName.APPENDER)) {
            throw new MyLoggerPropertyException("\'appender\' property not found.");
        }

        MultipleLogger multipleLogger = new MultipleLogger();

        String appenderProperty = manager.getValue(PropertiesName.APPENDER);
        if (appenderProperty.toUpperCase().contains(Appender.CONSOLE.toString())) {
            multipleLogger.addLogger(getConsoleLogger(clazz, level));
        }

        if (!appenderProperty.toUpperCase().contains(Appender.FILE.toString())) {
            return multipleLogger;
        }

        String fileName = manager.getValue(PropertiesName.FILE);
        multipleLogger.addLogger(getFileLogger(clazz, fileName, level));
        return multipleLogger;
    }


    public static Level getLevel() {
        if (!manager.containsKey(PropertiesName.LEVEL)) {
            return DEFAULT_LOG_LEVEL;
        }

        String levelString = manager.getValue(PropertiesName.LEVEL).toUpperCase();
        return Level.valueOf(levelString);
    }

    public static Logger getConsoleLogger(Class clazz) {
        Level level = getLevel();
        return getConsoleLogger(clazz, level);
    }

    public static Logger getConsoleLogger(Class clazz, Level level) {
        ConsoleLogger consoleLogger = new ConsoleLogger(clazz);
        consoleLogger.setLogLevel(level);
        return consoleLogger;
    }

    public static Logger getFileLogger(Class clazz) {
        Level level = getLevel();
        String fileName = manager.getValue(PropertiesName.FILE);
        return getFileLogger(clazz, fileName, level);
    }

    public static Logger getFileLogger(Class clazz, String fileName) {
        Level level = getLevel();
        return getFileLogger(clazz, fileName, level);
    }

    public static Logger getFileLogger(Class clazz, String fileName, Level level) {
        FileLogger fileLogger = new FileLogger(clazz, fileName);
        fileLogger.setLogLevel(level);
        return fileLogger;
    }
}
