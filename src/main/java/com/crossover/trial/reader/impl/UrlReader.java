/**
 * 
 */
package com.crossover.trial.reader.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

/**
 * @author vamshi.vijay
 *
 */
public class UrlReader {

	/* (non-Javadoc)
	 * @see com.crossover.trial.reader.Reader#getStream(java.lang.String)
	 */
	public InputStream getStream(String path) {
		//InputStream input = new URL("http://www.somewebsite.com/a.txt").openStream();
		InputStream input = null;
		try {
			input = new URL(path).openStream();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		return input;
	}
	
	public static void main(String[] args) {
		UrlReader ur = new UrlReader();
		Properties pr = new Properties();
		
		InputStream in = ur.getStream("file:///Users/vamshi.vijay/codebase/test/properties-dist/src/main/resources/aws.properties");
		try {
			pr.load(in);
			System.out.println(pr.keySet());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
