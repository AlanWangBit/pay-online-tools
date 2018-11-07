package com.alan.pay.utils;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author Alan Wang
 * @Date 2018/6/8.
 */
public class PropertiesUtils {

    private static Properties properties;
    private static PropertiesUtils propertiesUtils;

    public static PropertiesUtils init() {
        if(propertiesUtils==null) {
            propertiesUtils = new PropertiesUtils();
        }

        return propertiesUtils;
    }

    public Object getValue(String fileName, String key) {
        properties = new Properties();
        InputStream in = PropertiesUtils.class.getResourceAsStream("/"+fileName);

        try {
            properties.load(in);
            if(properties.getProperty(key) == null) {
                return null;
            }
            return properties.getProperty(key).trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
