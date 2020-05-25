package com.epam.ekids.mylogger;

import java.util.ResourceBundle;

public class PropertiesManager {

    private static PropertiesManager INSTANCE = new PropertiesManager();

    public static PropertiesManager getInstance() {
        return INSTANCE;
    }

    private PropertiesManager() {
    }

    private ResourceBundle bundle = ResourceBundle.getBundle("mylogger");

    public String getValue(String key) {
        return bundle.getString(key);
    }

    public boolean containsKey(String key) {
        return bundle.containsKey(key);
    }

}
