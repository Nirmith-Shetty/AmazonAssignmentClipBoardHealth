package com.amazon.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {

    static Properties prop=new Properties();

    public static String getValue(String key) throws IOException {
        FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/env.properties");
        prop.load(file);
       return prop.getProperty(key);
    }

}
