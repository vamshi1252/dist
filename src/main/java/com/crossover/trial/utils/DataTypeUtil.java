package com.crossover.trial.utils;

import com.amazonaws.regions.Regions;

import static com.crossover.trial.utils.DataType.*;

/**
 * Utility class to determine the data type of the property
 * 
 * @author vamshi.vijay
 */
public class DataTypeUtil {

    /**
     * determines the data type of the given keyword value
     * 
     * @param string
     * @return classname of the property value
     */
    public static String getDataType(String string) {

        String trimmedString = string.trim();

        if (isAwsRegion(trimmedString)) {

            return REGION.getClassName();
        }

        if (isInteger(trimmedString)) {

            return INTEGER.getClassName();
        }

        if (isLong(trimmedString)) {

            return LONG.getClassName();
        }

        if (isDouble(trimmedString)) {

            return DOUBLE.getClassName();
        }

        if (isBoolean(trimmedString)) {

            return BOOLEAN.getClassName();
        }
        return STRING.getClassName();

    }

    private static boolean isAwsRegion(String string) {

        try {

            Regions.fromName(string);
        } catch (IllegalArgumentException e) {

            return false;
        }
        return true;
    }

    private static boolean isInteger(String string) {

        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static boolean isDouble(String string) {

        try {
            Double.parseDouble(string);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static boolean isLong(String string) {

        try {
            Long.parseLong(string);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static boolean isBoolean(String string) {

        return string.equalsIgnoreCase(Boolean.TRUE.toString()) || string.equalsIgnoreCase(Boolean.FALSE.toString());
    }
}
