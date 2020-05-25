package com.epam.ekids.mylogger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class FileLogger {

    // trace, debug, info, warn, error
    private Level logLevel = Level.DEBUG;

    private Class clazz;

    private BufferedWriter writer;

    public FileLogger(Class clazz, String fileName) {
        this.clazz = clazz;

        try {
            this.writer = new BufferedWriter(new FileWriter(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
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

        String message = LocalDateTime.now().toString() + " " + level + " " + clazz + " " +": " + text + '\n';

        try {
            writer.append(message);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
