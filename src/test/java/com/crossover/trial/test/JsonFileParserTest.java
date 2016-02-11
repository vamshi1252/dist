package com.crossover.trial.test;

import com.crossover.trial.exception.ConfigException;
import com.crossover.trial.parser.impl.JsonFileParserImpl;
import com.crossover.trial.properties.TrialAppProperties;
import com.crossover.trial.reader.Reader;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class JsonFileParserTest {

    @Test
    public void testJsonFileParser() {

        Reader reader = new Reader();
        InputStream inputStream = reader.getStream("classpath", "classpath:config.json");
        JsonFileParserImpl jsonFileParser = new JsonFileParserImpl();
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
