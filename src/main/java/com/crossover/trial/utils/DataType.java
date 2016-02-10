package com.crossover.trial.utils;

import com.amazonaws.regions.Regions;
import lombok.Getter;
import org.json.simple.JSONArray;

public enum DataType {

    INTEGER(Integer.class.toString()),
    LONG(Long.class.toString()),
    STRING(String.class.toString()),
    BOOLEAN(Boolean.class.toString()),
    REGION(Regions.class.toString()),
    DOUBLE(Double.class.toString());

    @Getter
    private String className;

    DataType(String className) {

        this.className = className;
    }

    public static DataType fromName(String className) {

        for (DataType dataType : DataType.values()) {
            if (className.equals(dataType.getClassName())) {
                return dataType;
            }
        }
        return null;
    }
}
