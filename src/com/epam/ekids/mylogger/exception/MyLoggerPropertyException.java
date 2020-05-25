package com.epam.ekids.mylogger.exception;

public class MyLoggerPropertyException extends RuntimeException {
    public MyLoggerPropertyException() {
        super();
    }

    public MyLoggerPropertyException(String message) {
        super(message);
    }

    public MyLoggerPropertyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyLoggerPropertyException(Throwable cause) {
        super(cause);
    }

    protected MyLoggerPropertyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
