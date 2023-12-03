package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties prop;
	
	public ReadConfig() {
		File src = new File("./Configuration/ReadConfig.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getBaseUrl() {
		return prop.getProperty("baseUrl");
	}
	
	public String getUsername() {
		return prop.getProperty("userName");
	}
	
	public String getPassword() {
		return prop.getProperty("password");
	}
	
	public String getChromePath() {
		return prop.getProperty("chromeDriverPath");
	}
	
	public String getFirefoxPath() {
		return prop.getProperty("geckoDriverPath");
	}

}
