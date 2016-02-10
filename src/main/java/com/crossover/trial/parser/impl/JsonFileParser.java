package com.crossover.trial.parser.impl;

import com.crossover.trial.dto.TrialProperty;
import com.crossover.trial.parser.Parser;
import com.crossover.trial.utils.DataTypeUtil;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Created by Anirudh Rachuri on 9/2/16.
 */
public class JsonFileParser implements Parser {

    @Override
    public List<TrialProperty> getProps(InputStream data) {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(data));
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

                TrialProperty property = new TrialProperty(key.toString(), DataTypeUtil.getDataType(obj.get(key)), obj
                        .get(key).toString(), true);
                trialProperties.add(property);
            }
            return trialProperties;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private JSONObject parseJSON(String data) throws ParseException {

        JSONParser jsonParser = new JSONParser();
        return (JSONObject) jsonParser.parse(data);
    }

    public static void main(String[] args) throws ParseException {
        JsonFileParser jsonFileParser = new JsonFileParser();
        JSONObject obj = jsonFileParser
                .parseJSON("{ \"auth.endpoint.uri\": \"https://authserver/v1/auth\", \"job.timeout\": 3600, \"sns.broadcast.topic_name\": \"broadcast\", \"score.factor\": 2.4, \"jpa.showSql\": false, \"aws_region_id\": \"us-east-1\" }");
        System.out.println(obj.keySet());
        System.out.println(Object.class.toString());
        for (Object key : obj.keySet()) {

            TrialProperty property = new TrialProperty(key.toString(), DataTypeUtil.getDataType(obj.get(key)), obj.get(
                    key).toString(), true);
            
            System.out.println(property);
        }
    }
}
