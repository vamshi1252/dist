/**
 * 
 */
package com.crossover.trial.parser;

import java.io.InputStream;
import java.util.List;

import com.crossover.trial.dto.TrialProperty;
import com.crossover.trial.exception.ConfigException;
import com.crossover.trial.properties.TrialAppProperties;

/**
 * @author vamshi.vijay
 *
 */
public interface Parser {
	
	void getProps(InputStream inputStream, TrialAppProperties trialAppProperties) throws ConfigException;
	
}
