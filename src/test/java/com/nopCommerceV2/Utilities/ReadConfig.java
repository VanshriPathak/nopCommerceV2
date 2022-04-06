package com.nopCommerceV2.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig(){ // constructor
		File src= new File("C:/Users/16097/workspace/eclipse_neon_may2021/nopCommerceV1/Configuration/config.properties");
		try{
			FileInputStream fis = new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
		} catch (Exception e){
			System.out.println("Exception is: "+ e.getMessage());
		}
	}
	
	// methods to access parameters from config.properties
	public String getApplicationURL(){
		String url= pro.getProperty("baseURL");
		return url; 
	}
	public String getUseremail(){
		String userName= pro.getProperty("useremail");
		return userName;
	}
	public String getPassword(){
		String pwd= pro.getProperty("password");
		return pwd; 
	}
	public String getChromePath(){
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	public String getEdgePath(){
		String edgepath=pro.getProperty("Edgepath");
		return edgepath; 
	}

}
