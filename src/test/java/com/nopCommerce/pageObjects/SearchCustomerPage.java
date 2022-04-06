package com.nopCommerce.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {
	public WebDriver rdriver; 
	
	public SearchCustomerPage(WebDriver driver){
		rdriver = driver ; 
		PageFactory.initElements(driver, this);
	}
	
	By txtEmailSearch= By.xpath("//input[@id='SearchEmail']"); 
	By txtFirstNameSearch= By.xpath("//input[@id='SearchFirstName']");
	By txtLastNameSearch= By.xpath("//input[@id='SearchLastName']");
	By btnSearch = By.xpath("//button[@id='search-customers']");
	
	public void SearchByEmail(String search_email){
		rdriver.findElement(txtEmailSearch).sendKeys(search_email);
	}
	
	public void SearchByFirstName(String search_firstname){
		rdriver.findElement(txtFirstNameSearch).sendKeys(search_firstname);;
	}
	
	public void SearchByLastName(String search_lastName){
		rdriver.findElement(txtLastNameSearch).sendKeys(search_lastName);
	}
	
	public void ClickOnSearch(){
	rdriver.findElement(btnSearch).click();
	}
	
}
