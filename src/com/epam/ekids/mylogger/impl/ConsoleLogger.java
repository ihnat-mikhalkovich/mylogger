package com.epam.ekids.mylogger.impl;

import com.epam.ekids.mylogger.AbstractLogger;
import com.epam.ekids.mylogger.Level;
import com.epam.ekids.mylogger.Logger;

import java.time.LocalDateTime;

public class ConsoleLogger extends AbstractLogger implements Logger {

    public ConsoleLogger(Class clazz) {
        super(clazz);
    }

    public void process(String text, Level level) {
        System.out.println(LocalDateTime.now().toString() + " " + level + " " + clazz + " " +": " + text);
    }
}