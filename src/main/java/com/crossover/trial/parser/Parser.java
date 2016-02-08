/**
 * 
 */
package com.crossover.trial.parser;

import com.crossover.trial.dto.TrialProperty;

import java.io.InputStream;
import java.util.List;

/**
 * @author vamshi.vijay
 *
 */
public interface Parser {

    List<TrialProperty> getProps(InputStream data);

}
