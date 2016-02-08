package com.crossover.trial.properties;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.crossover.trial.factory.ParserFactory;
import com.crossover.trial.reader.Reader;

/**
 * A simple main method to load and print properties. You should feel free to change this class or to create additional
 * class. You may add addtional methods, but must implement the AppPropertiesManager API contract.
 * 
 * Note: a default constructor is required
 *
 * @author code test administrator
 */
public class TrialAppPropertiesManager implements AppPropertiesManager {
	
	private static final Reader reader = new Reader();

    @Override
    public AppProperties loadProps(List<String> propUris) {
    	
    	String p= "classpath:resources/jdbc.properties";
    	
    	TrialAppProperties trialAppProperties = new TrialAppProperties();
    	if(CollectionUtils.isNotEmpty(propUris)) {
    		for(String path : propUris) {
    		     String type = path.split(":")[0];
    		     InputStream inputStream  = reader.getStream(type, path);
    		     ParserFactory.getInstance(path.split(".")[1]);
    		}
    	}
    	
    	
        return trialAppProperties;
    }

    @Override
    public void printProperties(AppProperties props, PrintStream sync) {
        sync.println(props);
    }
}
