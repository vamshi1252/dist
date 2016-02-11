/**
 * 
 */
package com.crossover.trial.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author vamshi.vijay
 *
 */
public class Test {

    private Properties prop = null;

    public Test() {

        InputStream is = null;
        try {
            this.prop = new Properties();
            is = this.getClass().getResourceAsStream("/aws.properties");
            prop.load(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String a[]) {
        Test mpc = new Test();
        System.out.println(mpc.getPropertyValue("aws_access_key"));
        System.out.println(mpc.getProp().keySet());
        // System.out.println("db.user: "+mpc.getPropertyValue("db.user"));
        // System.out.println("db.password: "+mpc.getPropertyValue("db.password"));
    }

    public String getPropertyValue(String key) {
        return this.prop.getProperty(key);
    }

    public Properties getProp() {
        return this.prop;
    }

}
