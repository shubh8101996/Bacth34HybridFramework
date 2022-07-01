package com.hybrid.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	
	Properties prop;
	
	String path="C:\\Users\\Unique Web System\\new WorkSpace\\HybridFrameworkBatch34\\Configuration\\Config.properties";
	
	
	public ReadConfig() {
		
		prop=new Properties();
		try {
			FileInputStream f=new FileInputStream(path);
			prop.load(f);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public String getBaseUrl() {
		
		String value=prop.getProperty("baseURL");
		
		if(value!=null) {
			
		return value;
		
		}
		else {
			
			throw new RuntimeException("URL NOT SPECIFIED IN CONFIG FILE");
		}
	}
	
	
public String getBrowser() {
		
		String browser=prop.getProperty("browser");
		
		if(browser!=null) {
			
		return browser;
		
		}
		else {
			
			throw new RuntimeException("URL NOT SPECIFIED IN CONFIG FILE");
		}
	}

}
