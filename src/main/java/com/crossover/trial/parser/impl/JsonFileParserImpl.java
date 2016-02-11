package com.crossover.trial.parser.impl;

import com.crossover.trial.dto.TrialProperty;
import com.crossover.trial.exception.ConfigException;
import com.crossover.trial.parser.Parser;
import com.crossover.trial.properties.TrialAppProperties;
import com.crossover.trial.utils.DataTypeUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 * JsonParser to extract the properties form Json files
 * 
 * @author vamshi.vijay
 */
@Slf4j
public class JsonFileParserImpl implements Parser {

    /**
     * Populates the properties extracted from inputstream to TrialAppProperties
     * 
     * @param inputStream stream from which properties need to be extracted
     * @param trialAppProperties properties will be populated into this object
     * @throws ConfigException
     */
    @Override
    public void getProps(InputStream inputStream, TrialAppProperties trialAppProperties) throws ConfigException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line = "";
        try {

            while ((line = bufferedReader.readLine()) != null) {

                stringBuilder.append(line);
            }
            JSONParser jsonParser = new JSONParser();
            JSONObject obj = (JSONObject) jsonParser.parse(stringBuilder.toString());

            log.info("Parsed a json file");
            for (Object key : obj.keySet()) {

                String propertyName = key.toString();
                String propertyValue = obj.get(key).toString();
                String propertyType = DataTypeUtil.getDataType(propertyValue);
                TrialProperty property = new TrialProperty(propertyName, propertyType, propertyValue, true);

                if (StringUtils.isBlank(propertyValue)) {

                    property.setKnown(false);
                }
                log.info("Parsed a TrialProperty: [{}] from json", property);
                trialAppProperties.setProperties(property);
            }
        } catch (IOException e) {
            throw new ConfigException("Exception occurred while reading json file", e);
        } catch (ParseException e) {
            throw new ConfigException("Exception occurred while parsing json file", e);
        }
    }
}
