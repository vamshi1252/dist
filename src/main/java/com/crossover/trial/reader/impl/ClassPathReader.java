/**
 * 
 */
package com.crossover.trial.reader.impl;

import java.io.InputStream;

import com.crossover.trial.reader.Reader;

/**
 * @author vamshi.vijay
 *
 */
public class ClassPathReader   {
	
	/* (non-Javadoc)
	 * @see com.crossover.trial.reader.Reader#getStream(java.lang.String)
	 */
	public InputStream getStream(String path) {
		 return  this.getClass().getResourceAsStream("/" + path);
	}

}
