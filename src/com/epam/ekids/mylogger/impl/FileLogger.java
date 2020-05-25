package com.epam.ekids.mylogger.impl;

import com.epam.ekids.mylogger.AbstractLogger;
import com.epam.ekids.mylogger.exception.FileLoggerException;
import com.epam.ekids.mylogger.Level;
import com.epam.ekids.mylogger.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class FileLogger extends AbstractLogger implements Logger {

    private BufferedWriter writer;

    private final static String DEFAULT_LOG_FILE_NAME = "log.log";

    public FileLogger(Class clazz) {
        this(clazz, DEFAULT_LOG_FILE_NAME);
    }

    public FileLogger(Class clazz, String fileName) {
        super(clazz);
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

    public void process(String text, Level level) {
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
