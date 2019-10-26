package com.testsol.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class WebTest extends UtilityTest{
	
	//logger initiation 
	private Logger Log = LogManager.getLogger(WebTest.class.getName());


	@Test
	public void DemoTest() {
		
		System.out.println("This is Demo Test");
		//driver.get("https://www.google.com");
	}
	
	@Test
	public void getPageTitle() throws IOException {
		
		Properties prop = Login();
		
		//load log4j properties
		PropertyConfigurator.configure("log4j.properties");
		
		//get the driver
		String driverStr = prop.getProperty("driver");
				
		//get the url
		url = prop.getProperty("url");
		
		Log.debug("driver="+ driverStr );
		Log.debug("url="+ url );
				
		//if driver is chrome
		if(driverStr.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:\\selenium\\Chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
					
				
		}
		//if driver is IE
		else if(driverStr.equalsIgnoreCase("ie")) {
					//code for ie
			System.setProperty("webdriver.ie.driver", "F:\\selenium\\IEdriver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
				
		//if driver is firefox
		else if(driverStr.equalsIgnoreCase("firefox")) {
					// code for firefox
			driver = new FirefoxDriver();	
		}

		//navigate to url
		driver.get(url);
		
		//get page title
		String pageTitle = driver.getTitle();
		Log.debug("pageTitle="+ pageTitle );
		
		if(pageTitle!=null && !pageTitle.isEmpty()) {
			System.out.println("Page Title="+pageTitle);
		}
		driver.quit();
		
		
		
	}
	
	


}
