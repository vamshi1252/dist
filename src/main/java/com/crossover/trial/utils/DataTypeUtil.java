package com.crossover.trial.utils;

import com.amazonaws.regions.Regions;

import static com.crossover.trial.utils.DataType.*;

/**
 *
 * Created by Anirudh Rachuri on 9/2/16.
 */
public class DataTypeUtil {

    public static String getDataType(Object object) {

        try {

            System.out.println(object.getClass().toString());
            switch (DataType.fromName(object.getClass().toString())) {

                case INTEGER:
                    return INTEGER.getClassName();

                case LONG:
                    return isInteger((Long) object) ? Integer.class.toString() : LONG.getClassName();

                case STRING:
                    return isAwsRegion(object.toString()) ? REGION.getClassName() : STRING.getClassName();

                case BOOLEAN:
                    return BOOLEAN.getClassName();

                case DOUBLE:
                    return DOUBLE.getClassName();

                default:
                    return Object.class.toString();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return object.getClass().toString();
        }
    }

    private static boolean isAwsRegion(String string) {

        try {

            Regions.fromName(string);
        } catch (IllegalArgumentException e) {

            return false;
        }
        return true;
    }

    private static boolean isInteger(Long value) {

        try {
            Math.toIntExact(value);
        } catch (ArithmeticException e) {
            return false;
        }
        return true;
    }
}
