package com.epam.ekids.mylogger.impl;

import com.epam.ekids.mylogger.AbstractLogger;
import com.epam.ekids.mylogger.Level;
import com.epam.ekids.mylogger.Logger;

import java.util.ArrayList;
import java.util.List;

public class MultipleLogger extends AbstractLogger implements Logger {

    private List<Logger> loggers = new ArrayList<>();

    public void addLogger(Logger logger) {
        loggers.add(logger);
    }

    @Override
    public void log(String text, Level level) {
        process(text, level);
    }

    @Override
    protected void process(String text, Level level) {
        for (Logger logger : loggers) {
            logger.log(text, level);
        }
    }
}
