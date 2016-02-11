package com.crossover.trial.properties;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;

import com.crossover.trial.dto.TrialProperty;

/**
 * A dummy implementation of TrialAppProperties, this clearly doesn't work. Candidates SHOULD change this class to add
 * their implementation. You are also free to create additional classes
 *
 * note: a default constructor is required.
 *
 * @author code test administrator
 */
public class TrialAppProperties implements AppProperties {
	
	private Map<String, TrialProperty> properties = new TreeMap<String, TrialProperty>();
	private List<String> missingProperties =  new ArrayList<String>();
	private List<String> knownProperties =  new ArrayList<String>();
	private boolean valid = true;

    @Override
    public List<String> getMissingProperties() {
        return missingProperties;
    }

    @Override
    public List<String> getKnownProperties() {
        return knownProperties;
    }

    @Override
    public boolean isValid() {
        return valid;
    }

    @Override
    public void clear() {
    	knownProperties.clear();
    	missingProperties.clear();
    	properties.clear();
    	valid=true;
    }

    @Override
    public Object get(String key) {
    	if(StringUtils.isNotEmpty(key)) {
    		key.replace(".", "_");
    		TrialProperty trialProperty = properties.get(key.toLowerCase());
    		if(trialProperty!=null) {
    			return trialProperty.getPropertyValue();
    		}
    	}
        return null;
    }
    
    public void setProperties(TrialProperty trialProperty) {
    	if(trialProperty == null) {
    		return;
    	}
    	if(trialProperty.isKnown()) {
    		this.properties.put(trialProperty.getPropertyName().toLowerCase().replace('.', '_'), trialProperty);
    		if(!knownProperties.contains(trialProperty.getPropertyName().toLowerCase())) {
    			knownProperties.add(trialProperty.getPropertyName().toLowerCase());
    		}
    	} else {
    		if(!missingProperties.contains(trialProperty.getPropertyName().toLowerCase())) {
    			missingProperties.add(trialProperty.getPropertyName().toLowerCase());
    		}
    	}
    	
    }
    
    public void setFlag(boolean valid) {
    	this.valid = valid;
    }
    
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	for (Map.Entry<String, TrialProperty> entry : properties.entrySet()) {
    		TrialProperty tp = entry.getValue();
    		
    		sb.append(tp.getPropertyName());
    		sb.append(", " + tp.getPropertyType());
    		sb.append(", " + tp.getPropertyValue());
    		sb.append("\n");
		}
    	return sb.toString();
    }
}
