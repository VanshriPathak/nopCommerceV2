package com.nopCommerceV2.testCases;


import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopCommerce.pageObjects.LoginPage;
import com.nopCommerceV2.Utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends BaseClass{

	@Test(dataProvider="LoginData")
	public void loginTest(String user, String pwd) throws InterruptedException, IOException {
		
		System.out.println("THe url, username and password are : "+ baseURL +" n "+ user +" n "+ pwd );
		driver.get(baseURL);
		driver.manage().window().maximize(); 
		
		LoginPage lp = new LoginPage(driver);
				
		lp.setUserName(user);
		logger.info("User provided"); //logger msg
		
		lp.setPassword(pwd);
		logger.info("Password provided");//logger msg
		
		lp.clickLogin();
		logger.info("Login in Clicked");//logger msg
		
		Thread.sleep(2000);
		
		if (driver.getTitle().equals("Dashboard / nopCommerce administration")) {
			lp.clickLogout();
			Assert.assertTrue(true);
					
		} else {
			logger.info("Login Failed");//logger msg
			Assert.assertTrue(false);
		}

	}
		
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/nopCommerceV2/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		System.out.println("Number of row and columns are "+ rownum + " n "+ colcount);
	
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);
			}
		}
		
		return logindata;
		
	}
	
}
