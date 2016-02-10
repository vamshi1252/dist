package com.crossover.trial.parser.impl;

import com.crossover.trial.dto.TrialProperty;
import com.crossover.trial.exception.ConfigException;
import com.crossover.trial.parser.Parser;
import com.crossover.trial.properties.TrialAppProperties;
import com.crossover.trial.utils.DataTypeUtil;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class JsonFileParser implements Parser {

    @Override
    public void getProps(InputStream inputStream, TrialAppProperties trialAppProperties) throws ConfigException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line = "";
        List<TrialProperty> trialProperties = new ArrayList<>();
        try {

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            JSONParser jsonParser = new JSONParser();
            JSONObject obj = (JSONObject) jsonParser.parse(stringBuilder.toString());

            for (Object key : obj.keySet()) {

                String propertyName = key.toString();
                String propertyValue = obj.get(key).toString();
                String propertyType = DataTypeUtil.getDataType(propertyValue);
                TrialProperty property = new TrialProperty(propertyName, propertyType, propertyValue, true);

                if (StringUtils.isBlank(propertyValue)) {

                    property.setKnown(false);
                }
                trialAppProperties.setProperties(property);
            }
        } catch (IOException e) {
            throw new ConfigException("Exception occurred while reading json file", e);
        } catch (ParseException e) {
            throw new ConfigException("Exception occurred while paring json", e);
        }
    }

    private JSONObject parseJSON(String data) throws ParseException {

        JSONParser jsonParser = new JSONParser();
        return (JSONObject) jsonParser.parse(data);
    }


}
