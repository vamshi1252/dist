/**
 * 
 */
package com.crossover.trial.reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author vamshi.vijay
 *
 */
public class  Reader {
	
	public  InputStream getClassPathStream(String path) {
		 return  this.getClass().getResourceAsStream("/" + path);
	}
	
	public  InputStream getFileStream(String path) {
		InputStream input = null;
		try {
			 input = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
		return input;
	}
	
	public InputStream getUrlStream(String path) {
		InputStream input = null;
		try {
			input = new URL(path).openStream();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		return input;
	}
	
	public  InputStream getStream(String type, String path) {
		switch(type.toLowerCase()) {
	     case "file" :
	    	  return getUrlStream(path);
	     case "classpath":
	    	 if(path.split(":").length >1) 
	    		 return getClassPathStream("/" + path.split(":")[1]);
	    	 else 
	    		 return null;
	     case "http":
	    	 return getUrlStream(path);
	     default : 
	    	 return null;
	     }
	}
	
}
