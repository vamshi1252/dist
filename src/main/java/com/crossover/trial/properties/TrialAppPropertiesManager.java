package com.crossover.trial.properties;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.crossover.trial.dto.TrialProperty;
import com.crossover.trial.exception.ConfigException;
import com.crossover.trial.factory.ParserFactory;
import com.crossover.trial.parser.Parser;
import com.crossover.trial.reader.Reader;

/**
 * @author code test administrator
 */
public class TrialAppPropertiesManager implements AppPropertiesManager {
	
	private static final Reader reader = new Reader();

    @Override
    public AppProperties loadProps(List<String> propUris) {
    	TrialAppProperties trialAppProperties = new TrialAppProperties();
    	if(CollectionUtils.isNotEmpty(propUris)) {
    		for(String path : propUris) {
    		     String type = path.split(":")[0];
    		     InputStream inputStream  = reader.getStream(type, path);
    		     String[] extensions = path.split("\\.");
    		     int len = extensions.length;
    		     Parser parser = ParserFactory.getInstance(extensions[len-1]);
    		     try {
					parser.getProps(inputStream,trialAppProperties);
				} catch (ConfigException e) {
					
					trialAppProperties.setFlag(false);
				}
    		}
    	}
        return trialAppProperties;
    }

    @Override
    public void printProperties(AppProperties props, PrintStream sync) {
        sync.println(props);
    }
    
    public static void main(String[] args) {
    	TrialAppPropertiesManager tp = new TrialAppPropertiesManager();
    	List<String> propUris  = new ArrayList<String>();
    	propUris.add("file:///Users/vamshi.vijay/codebase/test/properties-dist/src/main/resources/aws.properties");
    	tp.loadProps(propUris);
    }
}
