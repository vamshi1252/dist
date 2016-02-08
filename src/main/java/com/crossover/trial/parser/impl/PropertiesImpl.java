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

import com.crossover.trial.dto.TrialProperty;
import com.crossover.trial.parser.Parser;

/**
 * @author vamshi.vijay
 *
 */
public class PropertiesImpl implements Parser {

	/* (non-Javadoc)
	 * @see com.crossover.trial.parser.Parser#getProps(java.lang.String)
	 */
	@Override
	public List<TrialProperty> getProps(InputStream  inputStream) {
		if(inputStream == null) {
			return null;
		}
		List<TrialProperty> TrialProperties = new ArrayList<TrialProperty>();
		Properties properties = new Properties();
		try { 
			properties.load(inputStream);
			Enumeration e = properties.keys();
			 while (e.hasMoreElements()) {
				 TrialProperty tp = new TrialProperty();
			      String key = (String) e.nextElement();
			      tp.setPropertyName(key);
			      tp.setPropertyValue(properties.getProperty(key));
			      System.out.println(key + " -- " + properties.getProperty(key));
			      TrialProperties.add(tp);
			 }
		} catch (IOException e) {
		}
		return TrialProperties;
	}

}
