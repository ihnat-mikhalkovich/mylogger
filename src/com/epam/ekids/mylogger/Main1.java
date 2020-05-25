package com.epam.ekids.mylogger;

public class Main1 {
    public static void main(String[] args) {
        Level level = Level.DEBUG;
        System.out.println(level);
        System.out.println(Level.INFO);

        System.out.println(Level.TRACE.ordinal());
        System.out.println(Level.INFO.ordinal());
        System.out.println(Level.ERROR.ordinal());
    }
}
