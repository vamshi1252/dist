package com.crossover.trial.reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * This class is a utility class to read from differnt sources(classpath,url,file)
 * 
 * @author vamshi.vijay
 */
public class Reader {

    private static final String FILE      = "file";
    private static final String CLASSPATH = "classpath";
    private static final String HTTP      = "http";


    private InputStream getClassPathStream(String path) {
        return this.getClass().getResourceAsStream(path);
    }

    private InputStream getFileStream(String path) {
        InputStream input = null;
        try {
            input = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return input;
    }

    private InputStream getUrlStream(String path) {
        InputStream input = null;
        try {
            input = new URL(path).openStream();
        } catch (MalformedURLException e) {} catch (IOException e) {}
        return input;
    }

    public InputStream getStream(String type, String path) {
        switch (type.toLowerCase()) {
            case FILE:
                return getUrlStream(path);
            case CLASSPATH:
                if (path.split(":").length > 1)
                    return getClassPathStream("/" + path.split(":")[1]);
                else
                    return null;
            case HTTP:
                return getUrlStream(path);
            default:
                return null;
        }
    }

}
