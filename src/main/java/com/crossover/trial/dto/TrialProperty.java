/**
 * 
 */
package com.crossover.trial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author vamshi.vijay
 *
 */

@Data
@AllArgsConstructor
public class TrialProperty {

    private String propertyName;
    private String propertyType;
    private String propertyValue;

}
