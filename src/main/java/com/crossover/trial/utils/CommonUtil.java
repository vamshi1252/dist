package com.crossover.trial.utils;

import com.amazonaws.regions.Regions;

/**
 * 
 * Created by Anirudh Rachuri on 10/2/16.
 */
public class CommonUtil {

    static boolean isAwsRegion(String string) {

        try {

            Regions.fromName(string);
        } catch (IllegalArgumentException e) {

            return false;
        }
        return true;
    }
}
