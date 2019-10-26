package com.testsol.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UtilityTest {
	

	WebDriver driver = null;
	String url = null;
	
	@Test
	public Properties Login() throws IOException {
		
		//initiate webdriver
		
		
		//set properties from environment.properties
		Properties prop = new Properties();
		
		//set the file as environment.properties
		File file = new File("F:\\MySolSet\\Environment.properties");	
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);
		System.out.println("Currently in Login");
		
		
		
		
		return prop;
	}

}
