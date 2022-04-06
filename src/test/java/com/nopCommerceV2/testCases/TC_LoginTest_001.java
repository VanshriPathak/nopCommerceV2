package com.nopCommerceV2.testCases;

import org.apache.poi.util.SystemOutLogger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopCommerce.pageObjects.LoginPage;
 

public class TC_LoginTest_001 extends BaseClass {
	@Test
	public void loginTest() throws InterruptedException {
driver.get(baseURL);
		
		System.out.println("URL:"+ baseURL);
		
		LoginPage lp= new LoginPage(driver); 
	    
		lp.setUserName(userName);
		logger.info("User Provided");
		
		lp.setPassword(pwd);
		logger.info("Password Provided");
		Thread.sleep(3000);
		System.out.println("id and password: "+ userName +"  "+ "password"  );
		
		lp.clickLogin();
		logger.info("Login done ");
		
		System.out.println("The Title of page: "+ driver.getTitle());
		
		if (driver.getTitle().equals("Dashboard / nopCommerce administration")) {
			Thread.sleep(5000);
			lp.clickLogout();
			Assert.assertTrue(true);
			logger.info("Logout is sucessful");
		} else {
			Assert.assertTrue(false);
			logger.info("Login is failed ");
		}

	}
}
