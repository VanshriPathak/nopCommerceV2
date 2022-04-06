package com.nopCommerceV2.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopCommerce.pageObjects.AddcustomerPage;
import com.nopCommerce.pageObjects.LoginPage;

public class TC_AddCusomerTest_003 extends BaseClass {
	
@Test 
	public void addNewCustomer() throws InterruptedException, IOException{
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
		acp.clickOnAddnew();
		logger.info("Add new customer is clicked ..");
		
		String email= randomeString() + "@gmail.com";
		acp.setEmail(email);
		logger.info("email entered,,");
		Thread.sleep(3000);
		
		acp.setPassword("test12345");
		logger.info("Password set..");
		Thread.sleep(3000);
		
		// issue in below code
		acp.setFirstName("Anamika");
		logger.info("first name set..");
		Thread.sleep(3000);
		
		acp.setLastName("Malhotra");
		logger.info("last name is set ..");
		Thread.sleep(3000);
		
		acp.setGender("FeMale");
		logger.info("radio button gender selected ..");
		Thread.sleep(3000);
		
		acp.setDOB("12/06/1986");
		logger.info("dob set..");
		Thread.sleep(3000);
		
		acp.setCompanyName("IBM");
		logger.info("company name set ..");
		Thread.sleep(3000);
		
		acp.chkBoxIsTax();
		logger.info("Check Box is tax is set ..");
		Thread.sleep(3000); 
		
	/* 	acp.setNewsLetter("2");
		logger.info("NewsLetter is clicked ..");
		Thread.sleep(3000); */
		
		acp.setCustomerRole(1);
		logger.info("Customer role is set ..");
		Thread.sleep(3000);
		
		acp.setManagerOfVendor("Vendor 1");
		logger.info("Vendor 1 is selected ..");
		Thread.sleep(3000);
		
		acp.setAdminComment("This for testing page object model ");
		logger.info("Admin comment is selected ..");
		Thread.sleep(3000);
		
		acp.ClickOnSave();
		logger.info("validation started....");
		
		//String msg=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();
		
		String msg = driver.findElement(By.tagName("body")).getText();
			
		
		if(msg.contains("The new customer has been added successfully"))
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
		}
		else
		{
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
	}
}
