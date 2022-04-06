package com.nopCommerce.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddcustomerPage {
	public WebDriver rdriver; 
	
	public AddcustomerPage(WebDriver driver){
		rdriver= driver; 
		PageFactory.initElements(driver, this);
	}
	
	By lnkCustomer_menu = By.xpath("(//p[contains(text(),'Customers')])[1]");
	By lnkCustomer_menuitem= By.xpath("(//p[contains(text(),'Customers')])[2]");
	By btnAddNew= By.xpath("//a[normalize-space()='Add new']");
	By txtEmail=By.xpath("//input[@id='Email']");
	By txtPassword= By.xpath("//input[@id='Password']");
	By txtFirstname= By.xpath("//input[@id='FirstName']");
	By txtLastname= By.xpath("//input[@id='LastName']");
	By rdMaleGender= By.xpath("//input[@id='Gender_Male']");
	By rdFemaleGender= By.xpath("//input[@id='Gender_Female']");
	By txtDOB = By.xpath("//input[@id='DateOfBirth']");
	By txtCompanyname= By.xpath("//input[@id='Company']");
	By CBoxIsTaxEmpty= By.xpath("//input[@id='IsTaxExempt']");
	By txtNewletter = By.xpath("//input[@class='k-input k-readonly']");
	By txtCustomerRole= By.xpath("(//div[@role='listbox'])[2]");
	By listitemRegistered = By.xpath("(//li[@role='option'])[1]");
	By listitemAdministrator= By.xpath("(//li[@role='option'])[2]");
	By listitemGuest = By.xpath("(//li[@role='option'])[3]");
	By listitemForumModerator=By.xpath("(//li[@role='option'])[4]");
	By listitemVendors= By.xpath("(//li[@role='option'])[5]");
	By drpManagerOfVendor= By.xpath("//select[@id='VendorId']"); 
	By txtAdminComment= By.xpath("//textarea[@id='AdminComment']");
	By btnSubmit= By.xpath("//button[@name='save']");
	
	public void clickCustomerMenu(){
		rdriver.findElement(lnkCustomer_menu).click();	
	}
	public void clickCustomerMenuItem(){
		rdriver.findElement(lnkCustomer_menuitem).click();
	}
	public void clickOnAddnew(){
		// rdriver.findElement(btnAddNew).click();
		JavascriptExecutor js = (JavascriptExecutor) rdriver; 
		js.executeScript("arguments[0].click()",rdriver.findElement(btnAddNew));
	//WebElement customerInfo = rdriver.findElement(By.xpath("//div[@class='card-header with-border clearfix']"));
	//js.executeScript("arguments[0].click()", customerInfo);
	}
	public void setEmail(String email){
		rdriver.findElement(txtEmail).sendKeys(email);
	}
	public void setPassword(String pwd){
		rdriver.findElement(txtPassword).sendKeys(pwd);
	}
	public void setFirstName(String fname){
		rdriver.findElement(txtFirstname).sendKeys(fname);
	}
	public void setLastName(String lname){
		rdriver.findElement(txtLastname).sendKeys(lname);
	}
	
	public void setGender(String gender){
		if (gender.equals("Male")){
		rdriver.findElement(rdMaleGender).click();
		}
		else if (gender.equals("FeMale")){
			rdriver.findElement(rdFemaleGender).click();
		}
		else {
			rdriver.findElement(rdMaleGender).click(); // default set gender as Male 	
		}
	}
	
	public void setDOB(String dob){
		rdriver.findElement(txtDOB).sendKeys(dob);
	}
	public void setCompanyName(String cname){
		rdriver.findElement(txtCompanyname).sendKeys(cname);
	}
	public void chkBoxIsTax(){
		rdriver.findElement(CBoxIsTaxEmpty).click();
	}
	public void setNewsLetter(String nletter){
		Select drp =new Select( rdriver.findElement(txtNewletter));
		drp.selectByValue(nletter);
		//rdriver.findElement(txtNewletter).sendKeys(nletter);
	}
	
	public void setCustomerRole(int role){
		rdriver.findElement(txtCustomerRole).click();
		
		WebElement listitem; 
		switch(role)
		{
		case 1: 
			listitem=rdriver.findElement(listitemAdministrator);
			break; 
		case 2:
			listitem=rdriver.findElement(listitemGuest);
			break;
		case 3:
			listitem= rdriver.findElement(listitemRegistered);
			break;
		case  4:
			listitem =rdriver.findElement(listitemVendors);
			break;
		case 5:
			listitem=rdriver.findElement(listitemForumModerator);
			break;
		
		default:
			listitem= rdriver.findElement(listitemGuest);	
		}
		JavascriptExecutor js = (JavascriptExecutor) rdriver; 
		js.executeScript("arguments[0].click()", listitem);
		
	}
	
	public void setManagerOfVendor(String value){
		Select drp= new Select(rdriver.findElement(drpManagerOfVendor));
		drp.selectByVisibleText(value);
	}
	
	public void setAdminComment(String admComment){
		rdriver.findElement(txtAdminComment).sendKeys(admComment);
	}
	
	public void ClickOnSave(){
		rdriver.findElement(btnSubmit).click();
	}
}
