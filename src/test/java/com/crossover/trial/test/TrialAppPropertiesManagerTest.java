/**
 * 
 */
package com.crossover.trial.test;

import com.crossover.trial.properties.AppProperties;
import com.crossover.trial.properties.TrialAppPropertiesManager;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * @author vamshi.vijay
 *
 */
public class TrialAppPropertiesManagerTest {

    @Test
    public void applicationJsonTest() {
        TrialAppPropertiesManager tp = new TrialAppPropertiesManager();
        List<String> propUris = new ArrayList<String>();
        propUris.add("classpath:config.json");
        AppProperties ap = tp.loadProps(propUris);
        assertNotNull(ap);

    }

    @Test
    public void applicationEmptyLocationTest() {
        TrialAppPropertiesManager tp = new TrialAppPropertiesManager();
        List<String> propUris = new ArrayList<String>();
        AppProperties ap = tp.loadProps(propUris);
        assertNotNull(ap);
    }

    @Test
    public void applicationNullLocationTest() {
        TrialAppPropertiesManager tp = new TrialAppPropertiesManager();
        AppProperties ap = tp.loadProps(null);
        assertNotNull(ap);
    }

    @Test
    public void applicationPropertiesTest() {
        TrialAppPropertiesManager tp = new TrialAppPropertiesManager();
        List<String> propUris = new ArrayList<String>();
        propUris.add("classpath:aws.properties");
        AppProperties ap = tp.loadProps(propUris);
        assertNotNull(ap);
    }

    @Test
    public void applicationExtensionMissingTest() {
        TrialAppPropertiesManager tp = new TrialAppPropertiesManager();
        List<String> propUris = new ArrayList<String>();
        propUris.add("classpath:aws");
        AppProperties ap = tp.loadProps(propUris);
        assertNotNull(ap);
    }

}
