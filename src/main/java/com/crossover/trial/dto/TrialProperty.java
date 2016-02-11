/**
 * 
 */
package com.crossover.trial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * This class holds the property information
 * 
 * @author vamshi.vijay
 */

@Data
@AllArgsConstructor
public class TrialProperty {

    /** name of the property */
    private String  propertyName;
    /** data type of the property */
    private String  propertyType;
    /** value of the property */
    private String  propertyValue;
    /** flag to categorize known or unknown property */
    private boolean known;

    public TrialProperty() {}

}
