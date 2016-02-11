/**
 * 
 */
package com.crossover.trial.parser;

import com.crossover.trial.exception.ConfigException;
import com.crossover.trial.properties.TrialAppProperties;

import java.io.InputStream;

/**
 * This interface is for populating the properties extracted from files
 * 
 * @author vamshi.vijay
 *
 */
public interface Parser {

    /**
     * Populates the properties extracted from inputstream to TrialAppProperties
     * 
     * @param inputStream stream from which properties need to be extracted
     * @param trialAppProperties properties will be populated into this object
     * @throws ConfigException
     */
    void getProps(InputStream inputStream, TrialAppProperties trialAppProperties) throws ConfigException;

}
