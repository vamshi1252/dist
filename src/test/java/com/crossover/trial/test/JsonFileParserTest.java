package com.crossover.trial.test;

import com.crossover.trial.exception.ConfigException;
import com.crossover.trial.parser.impl.JsonFileParser;
import com.crossover.trial.properties.TrialAppProperties;
import com.crossover.trial.reader.Reader;
import org.junit.Test;

import java.io.InputStream;

/**
 *
 * Created by Anirudh Rachuri on 11/2/16.
 */
public class JsonFileParserTest {

    @Test
    public void testJsonFileParser() {

        Reader reader = new Reader();
        InputStream inputStream = reader.getStream("classpath", "classpath:config.json");
        JsonFileParser jsonFileParser = new JsonFileParser();
        TrialAppProperties trialAppProperties = new TrialAppProperties();

        try {
            jsonFileParser.getProps(inputStream, trialAppProperties);
            System.out.println(trialAppProperties.getKnownProperties());
            System.out.println(trialAppProperties.getMissingProperties());
            System.out.println(trialAppProperties.isValid());
        } catch (ConfigException e) {
            e.printStackTrace();
        }
    }
}
