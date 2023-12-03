package com.inetBanking.testCases;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.HomePage;
import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BasePage{
	
	
	@Test(dataProvider = "Login Data")
	public void loginDDT(String user, String pwd) {
		HomePage homePage=new HomePage(driver);
		LoginPage loginPage=new LoginPage(driver); 
	
		loginPage.enterUserName(user);
		loginPage.enterPassword(pwd);
		loginPage.clickLoginButton();
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}else {
			homePage.clickOnLogOutButton();
			driver.switchTo().alert().accept();
		}
	};
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	@DataProvider(name="Login Data")
	String[][] getData() throws Exception{
		
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/Test Data.xlsx";
		int rowNum=XLUtils.getRowCount(path, "Sheet1");
		int colCount=XLUtils.getColumnCount(path, "Sheet1", 1);
		
		String[][] loginData=new String[rowNum][colCount];
		
		for(int i=0;i<rowNum;i++) {
			
			for(int j=0;j<colCount;j++) {
				
				loginData[i][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		
		return loginData;

  }
	
	
}
