package com.epam.ekids.mylogger;

public class Main2 {
    public static void main(String[] args) {
        PropertiesManager manager = PropertiesManager.getInstance();
        System.out.println(manager.getValue(PropertiesName.LEVEL));

        System.out.println(Level.valueOf("DEBUG"));
    }
}
