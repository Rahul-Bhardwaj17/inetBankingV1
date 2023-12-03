package com.inetBanking.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.inetBanking.utilities.ReadConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BasePage {
	ReadConfig readConfig=new ReadConfig();
	public static WebDriver driver;
	//public String baseUrl="https://demo.guru99.com/v4/";
	public String baseUrl=readConfig.getBaseUrl();
	//public String userName="mngr26593";
	public String userName=readConfig.getUsername();
	//public String password="1234567@";
	public String password=readConfig.getPassword();
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		
		//configuration to add logger
				System.setProperty("log4j2.configurationFile", "log4j2.xml");
				logger = LogManager.getLogger(BasePage.class);	
		
		if(br.equals("chrome")) {
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Driver//chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",readConfig.getChromePath());
		driver=new ChromeDriver();
		}
		if(br.equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver",readConfig.getFirefoxPath());
			driver=new FirefoxDriver();
		}
		driver.get(baseUrl);
		
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
