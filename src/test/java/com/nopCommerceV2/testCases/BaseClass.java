package com.nopCommerceV2.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nopCommerceV2.Utilities.ReadConfig;

public class BaseClass {
	ReadConfig rc = new ReadConfig();
	public  String baseURL= rc.getApplicationURL();
	public  String userName= rc.getUseremail();
	public String pwd= rc.getPassword(); 
	 public WebDriver driver; 
	 public static org.apache.log4j.Logger logger ;
	 
	@Parameters("browser")
	@BeforeClass
	public void setup(String br )
	{
		
		 if (br.equals("chrome") ){
			 System.setProperty("webdriver.chrome.driver", rc.getChromePath());
			 driver= new ChromeDriver(); 
			 driver.manage().window().maximize();
			 driver.manage().deleteAllCookies();
			 }
			 else if (br.equals("edge")){
				 System.setProperty("webdriver.edge.driver", rc.getEdgePath());
				 driver= new EdgeDriver(); 
				 driver.manage().window().maximize();
				 driver.manage().deleteAllCookies();
			 }
		
	// Logger logger  = Logger.getLogger(GFG.class.getName());
			try{
		//logger =  LoggerFactory.getLogger(BaseClass.class.getName()); // add logger 
				logger = LogManager.getLogger(BaseClass.class.getName());
			}catch (NullPointerException e) {
	            System.out.println("Exception Thrown: "
	                    + e);}
			 PropertyConfigurator.configure("log4j.properties");
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public static void captureScreen(WebDriver driver, String tname) throws IOException{
		TakesScreenshot ts = (TakesScreenshot) driver ;
		File src= ts.getScreenshotAs(OutputType.FILE);
		File trg= new File("C:/Users/16097/workspace/eclipse_neon_may2021/nopCommerceV2/Screenshots/tname"+".png"); 
		FileUtils.copyFile(src, trg);
	}
	
	public static String randomeString(){
		String generatedString1= RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}
	
	public static String randomNum(){
		String generatedString2 = RandomStringUtils.randomNumeric(5);
		return (generatedString2);
	}
	
}
