package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetBanking.pageObjects.LoginPage;


public class TC_LoginTest_001 extends BasePage{
	
	
	@Test
	public void loginToWebsite() {
		
		LoginPage loginPage= new LoginPage(driver);
		loginPage.enterUserName(userName);
		loginPage.enterPassword(password);
		loginPage.clickLoginButton();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	}

}
