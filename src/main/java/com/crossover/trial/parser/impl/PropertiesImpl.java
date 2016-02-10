/**
 * 
 */
package com.crossover.trial.parser.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

import com.crossover.trial.dto.TrialProperty;
import com.crossover.trial.exception.ConfigException;
import com.crossover.trial.parser.Parser;
import com.crossover.trial.properties.TrialAppProperties;
import com.crossover.trial.utils.DataTypeUtil;

/**
 * @author vamshi.vijay
 *
 */
public class PropertiesImpl implements Parser {

	/* (non-Javadoc)
	 * @see com.crossover.trial.parser.Parser#getProps(java.lang.String)
	 */
	@Override
	public void getProps(InputStream  inputStream, TrialAppProperties trialAppProperties) throws ConfigException {
		if(inputStream == null) {
			return ;
		}
		Properties properties = new Properties();
		try { 
			properties.load(inputStream);
			Enumeration e = properties.keys();
			 while (e.hasMoreElements()) {
				 TrialProperty trialProperty = new TrialProperty();
			      String key = (String) e.nextElement();
			      trialProperty.setPropertyName(key);
			      if(StringUtils.isEmpty(properties.getProperty(key))) {
			    	  trialProperty.setKnown(false);
			      }
			      trialProperty.setPropertyValue(properties.getProperty(key));
			      trialProperty.setPropertyType(DataTypeUtil.getDataType((Object)properties.getProperty(key)));
			      trialAppProperties.setProperties(trialProperty);
			 }
		} catch (IOException | IllegalArgumentException  e) {
			throw new ConfigException("Exception occured while parsing properties file", e);
		}
	}
}
