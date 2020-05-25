package com.epam.ekids.mylogger;

import com.epam.ekids.mylogger.impl.ConsoleLogger;
import com.epam.ekids.mylogger.impl.FileLogger;
import com.epam.ekids.mylogger.impl.MultipleLogger;

public final class LoggerFactory {

    private LoggerFactory() {
    }

    public static Logger getLogger(Class clazz) {
        return new ConsoleLogger(clazz);
    }

    public static Logger getLogger(Class clazz, String fileName) {
        MultipleLogger multipleLogger = new MultipleLogger();

        Logger consoleLogger = new ConsoleLogger(clazz);
        multipleLogger.addLogger(consoleLogger);

        Logger fileLogger = new FileLogger(clazz, fileName);
        multipleLogger.addLogger(fileLogger);

        return multipleLogger;
    }
}
