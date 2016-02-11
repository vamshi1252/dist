package com.crossover.trial.factory;

import com.crossover.trial.parser.Parser;
import com.crossover.trial.parser.impl.JsonFileParserImpl;
import com.crossover.trial.parser.impl.PropertiesFileParserImpl;

/**
 * This class provides the parser object to parse json or properties files
 * 
 * @author vamshi.vijay
 *
 */
public class ParserFactory {

    private static final PropertiesFileParserImpl PropertiesImpl = new PropertiesFileParserImpl();

    private static final JsonFileParserImpl       jsonFileParser = new JsonFileParserImpl();

    /**
     * It returns the parser corresponding to parser type(json, property)
     * 
     * @param type json or property file
     * @return json parser or properties file parser
     */
    public static Parser getInstance(String type) {
        if ("properties".equalsIgnoreCase(type)) {
            return PropertiesImpl;
        } else if ("json".equalsIgnoreCase(type)) {
            return jsonFileParser;
        } else {
            return null;
        }
    }

}
