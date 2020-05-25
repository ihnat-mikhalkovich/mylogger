package com.epam.ekids.mylogger.exception;

public class FileLoggerException extends RuntimeException {
    public FileLoggerException() {
        super();
    }

    public FileLoggerException(String message) {
        super(message);
    }

    public FileLoggerException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileLoggerException(Throwable cause) {
        super(cause);
    }

    protected FileLoggerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
