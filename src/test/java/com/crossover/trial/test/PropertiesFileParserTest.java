/**
 * 
 */
package com.crossover.trial.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.InputStream;

import org.junit.Test;

import com.crossover.trial.exception.ConfigException;
import com.crossover.trial.parser.impl.PropertiesFileParserImpl;
import com.crossover.trial.properties.TrialAppProperties;
import com.crossover.trial.reader.Reader;

/**
 * @author vamshi.vijay
 *
 */
public class PropertiesFileParserTest {
	
    @Test
    public void testJsonFileParser() {

        Reader reader = new Reader();
        InputStream inputStream = reader.getStream("classpath", "classpath:config.json");
        PropertiesFileParserImpl jsonFileParser = new PropertiesFileParserImpl();
        TrialAppProperties trialAppProperties = new TrialAppProperties();

        try {
            jsonFileParser.getProps(inputStream, trialAppProperties);
            assertNotNull(trialAppProperties.getKnownProperties());
            assertNotNull(trialAppProperties.getMissingProperties());
            assertNotNull(trialAppProperties.isValid());
        } catch (ConfigException e) {
        	fail();
        }
    }

}
