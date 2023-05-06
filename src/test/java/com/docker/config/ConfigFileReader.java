package com.docker.config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Fatih Can Oklay
 * Date: 23.04.2023
 */

public class ConfigFileReader {

    private final Properties properties;

    public ConfigFileReader() {
        BufferedReader reader;
        String propertyFilePath = "src/main/configuration/config.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("configs.properties not found at " + propertyFilePath);
        }
    }

    public String getBaseUrl() {
        String baseUrl = properties.getProperty("baseUrl");
        if (baseUrl != null) return baseUrl;
        else throw new RuntimeException("BaseUrl not specified in the configs.properties file.");
    }

    public long getImplicityWait() {
        String implicityWait = properties.getProperty("implicityWait");
        if (implicityWait != null) return Long.parseLong(implicityWait);
        else throw new RuntimeException("ImplicitlyWait not specified in the configs.properties file.");
    }

    public long getPageLoadTimeout() {
        String pageLoadTimeout = properties.getProperty("pageLoadTimeout");
        if (pageLoadTimeout != null) return Long.parseLong(pageLoadTimeout);
        else throw new RuntimeException("PageLoadTimeout not specified in the configs.properties file.");
    }

    public long getWebDriverWait() {
        String webDriverWait = properties.getProperty("webDriverWait");
        if (webDriverWait != null) return Long.parseLong(webDriverWait);
        else throw new RuntimeException("PageLoadTimeout not specified in the configs.properties file.");
    }

    public String getRemoteUrl() {
        String remoteUrl = properties.getProperty("remoteUrl");
        if (remoteUrl != null) return remoteUrl;
        else throw new RuntimeException("RemoteUrl not specified in the configs.properties file.");
    }
}
