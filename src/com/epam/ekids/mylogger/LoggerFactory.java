package com.epam.ekids.mylogger;

import com.epam.ekids.mylogger.impl.ConsoleLogger;
import com.epam.ekids.mylogger.impl.FileLogger;

public final class LoggerFactory {

    private LoggerFactory() {
    }

    public static Logger getLogger(Class clazz) {
        return new ConsoleLogger(clazz);
    }

    public static Logger getLogger(Class clazz, String fileName) {
        return new FileLogger(clazz, fileName);
    }
}
