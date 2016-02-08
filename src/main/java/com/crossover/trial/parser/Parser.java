/**
 * 
 */
package com.crossover.trial.parser;

import java.io.InputStream;
import java.util.List;

import com.crossover.trial.dto.TrialProperty;

/**
 * @author vamshi.vijay
 *
 */
public interface Parser {
	
	List<TrialProperty> getProps(InputStream inputStream);
}
