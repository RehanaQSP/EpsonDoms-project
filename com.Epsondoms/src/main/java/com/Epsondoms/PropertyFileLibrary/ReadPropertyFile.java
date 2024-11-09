package com.Epsondoms.PropertyFileLibrary;


	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.util.Properties;

import com.Epsondoms.GenericLibrary.FrameworkConstant;

	public class ReadPropertyFile implements FrameworkConstant {
		
		public static FileInputStream fis;
		public static Properties property;
		public static FileOutputStream fos;
		
		public static String readdata(String key) {
			// 1. Convert The Physical file into Java Readable File
			try {
				fis = new FileInputStream(propertypath);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			// 2. Create an Object for properties class
			property = new Properties();
			
			// 3. Load all the keys/Data
			try {
				property.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			// 4. Fetch the data
			String data = property.getProperty(key);
			return data;
			
		}
		
		public static void writedate(String key, String value) {
			// 1. Convert The Physical file into Java Readable File
					try {
						FileInputStream fis = new FileInputStream(propertypath);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					
					// 2. Create an Object for properties class
					property = new Properties();
					
					// 3. Load all the keys/Data
					try {
						property.load(fis);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					//4. Write the data
					property.put(key, value);
					
					//5. Convert Java Readable into Physical file
					try {
						fos = new FileOutputStream(propertypath);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					
					//6. Store the data
					try {
						property.store(fos, "Latest key updated Successfully");
					} catch (IOException e) {
						
						e.printStackTrace();
					}
					
					
		}

	}


