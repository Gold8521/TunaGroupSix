package com.Testpack;

import io.appium.java_client.AppiumDriver;

public class SampleTest {
	
	static AppiumDriver driver;
	public SampleTest() throws Throwable {
	
		driver = SetupDriver.initDriver();
		
		
	}

	public static void main(String[] args) throws Throwable {
		
		System.out.println(driver);

	}


}
