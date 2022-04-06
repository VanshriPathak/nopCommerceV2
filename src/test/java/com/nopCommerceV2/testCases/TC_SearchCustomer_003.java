package com.nopCommerceV2.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopCommerce.pageObjects.AddcustomerPage;
import com.nopCommerce.pageObjects.LoginPage;
import com.nopCommerce.pageObjects.SearchCustomerPage;


public class TC_SearchCustomer_003 extends BaseClass {
	
	@Test 
	public void search_Customer() throws IOException{
	driver.get(baseURL);
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	LoginPage lp= new LoginPage(driver); // constructor for loginpage 
	lp.setUserName(userName);
	logger.info("userName is set...");
	lp.setPassword(pwd);
	logger.info("Password is set...");
	lp.clickLogin();
	logger.info("Log in is set...");
	
	AddcustomerPage acp = new AddcustomerPage(driver); // constructor for add Customer page 
	acp.clickCustomerMenu();
	logger.info("Customer in main menu click..");
	acp.clickCustomerMenuItem();
	logger.info("Customer sub menu click ..");
	
	SearchCustomerPage scp= new SearchCustomerPage(driver);
	
	scp.SearchByEmail("kOMZK@gmail.com");
	scp.ClickOnSearch();
	
	String msg=driver.findElement(By.xpath("//td[@class='dataTables_empty']")).getText();
	if(msg.equals("No data available in table")){
		Assert.assertTrue(true);
		logger.info("test case No data for customer info ....");
	}
	else
	{
		captureScreen(driver,"addNewCustomer");
		Assert.assertTrue(false);
		logger.info("test case customer is found ....");
	}
	
}
}
