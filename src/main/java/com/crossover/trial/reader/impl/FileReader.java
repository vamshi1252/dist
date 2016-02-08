/**
 * 
 */
package com.crossover.trial.reader.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author vamshi.vijay
 *
 */
public class FileReader {

	/* (non-Javadoc)
	 * @see com.crossover.trial.reader.Reader#getStream(java.lang.String)
	 */
	public  InputStream getStream(String path) {
		InputStream input = null;
		File file = new File("file:///Users/vamshi.vijay/codebase/test/properties-dist/src/main/resources/aws.properties");
		 try {
			 System.out.println(file.getAbsolutePath());
			input = new FileInputStream(file.getAbsolutePath());
			 Properties ps = new Properties();
				try {
					ps.load(input);
					System.out.println(ps.keySet());
				} catch (IOException e) {
					e.printStackTrace();
				}	
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
						
		return input;
	}
	
	public static void main(String[] args) {
	FileReader fr = new FileReader();
	fr.getStream("");
		
	}

}
