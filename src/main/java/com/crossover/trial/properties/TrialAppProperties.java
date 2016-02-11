package com.crossover.trial.properties;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;

import com.crossover.trial.dto.TrialProperty;

/**
 *This class categorizes the properties(missing, known etc)
 *
 * @author code test administrator
 */
public class TrialAppProperties implements AppProperties {
	
	private Map<String, TrialProperty> properties = new TreeMap<String, TrialProperty>();
	private List<String> missingProperties =  new ArrayList<String>();
	private List<String> knownProperties =  new ArrayList<String>();
	private boolean valid = true;

    /**
     * @return a list of properties that are unset either because they are missing or because they have the wrong type
     */
    @Override
    public List<String> getMissingProperties() {
        return missingProperties;
    }

    /**
     * @return a list of all known keys
     */
    @Override
    public List<String> getKnownProperties() {
        return knownProperties;
    }

    /**
     * @return true if the configuration is valid, false otherwise
     */
    @Override
    public boolean isValid() {
        return valid;
    }

    /**
     * resets all loaded properties to null / unloaded
     */
    @Override
    public void clear() {
    	knownProperties.clear();
    	missingProperties.clear();
    	properties.clear();
    	valid=true;
    }

    /**
     * Retrieves the property for the given key. Keys are case-insenstive and the use of . and _ in property names is
     * interchangable. For example, jpa.showSQL, jpa_showsql and JPA_showSql should all retrieve the same value.
     *
     * @param key a property key, handled without case sensitivity. '.' and '_' are treated as equivalent
     * @return an object of the given key or null if it is not available
     */
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
    
    /**
     * Sets the property for the given keys.
     *
     * @param trialProperty it holds the property information which is extracted and stored in corresponding fields
     */
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
