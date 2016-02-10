package com.crossover.trial.utils;

import static com.crossover.trial.utils.DataType.*;

/**
 *
 * Created by Anirudh Rachuri on 9/2/16.
 */
public class JSONDataTypeUtil extends CommonUtil {

    public static String getDataType(Object object) {

        try {

            if (object == null) {

                throw new NullPointerException();
            }
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
                    return object.getClass().toString();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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
