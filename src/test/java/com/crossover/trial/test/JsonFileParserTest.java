package com.crossover.trial.test;

import com.crossover.trial.dto.TrialProperty;
import com.crossover.trial.parser.impl.JsonFileParser;
import com.crossover.trial.reader.Reader;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 *
 * Created by Anirudh Rachuri on 11/2/16.
 */
public class JsonFileParserTest {

    @Test
    public void testJsonFileParser() {

        InputStream inputStream = new Reader().getClassPathStream("classpath:config.json");
        JsonFileParser jsonFileParser = new JsonFileParser();
        List<TrialProperty> trialProperties = jsonFileParser.getProps(inputStream);
        System.out.println(trialProperties);
    }
}
