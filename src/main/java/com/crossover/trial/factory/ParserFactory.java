/**
 * 
 */
package com.crossover.trial.factory;

import com.crossover.trial.parser.Parser;
import com.crossover.trial.parser.impl.PropertiesImpl;

/**
 * @author vamshi.vijay
 *
 */
public class ParserFactory {
	
	private static final PropertiesImpl PropertiesImpl = new PropertiesImpl();
	
	public static Parser getInstance(String type) {
		if("properties".equalsIgnoreCase(type)) {
			 return PropertiesImpl;
		} else if("json".equalsIgnoreCase(type)) {
			return PropertiesImpl;
		} else {
			return null;
		}
	}
	
}
