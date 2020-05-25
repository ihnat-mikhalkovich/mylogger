package com.epam.ekids.mylogger.impl;

import com.epam.ekids.mylogger.FileLoggerException;
import com.epam.ekids.mylogger.Level;
import com.epam.ekids.mylogger.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class FileLogger implements Logger {

    // trace, debug, info, warn, error
    private Level logLevel = Level.DEBUG;

    private Class clazz;

    private BufferedWriter writer;

    private final static String DEFAULT_LOG_FILE_NAME = "log.log";

    public FileLogger(Class clazz) {
        this(clazz, DEFAULT_LOG_FILE_NAME);
    }

    public FileLogger(Class clazz, String fileName) {
        this.clazz = clazz;
        this.writer = buildBufferedWriter(fileName);
    }

    private BufferedWriter buildBufferedWriter(String fileName) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(fileName));
        } catch (IOException e) {
            throw new FileLoggerException("Face exception when build BufferedWriter for file with name: " + fileName, e);
        }
        return writer;
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
        writeInFile(message);
    }

    private void writeInFile(String message) {
        try {
            writer.append(message);
            writer.flush();
        } catch (IOException e) {
            throw new FileLoggerException("Face exception when try to write in file.", e);
        }
    }
}
