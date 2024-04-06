package com.utill;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementFetch {
    public WebElement getWebElement(AppiumDriver driver, String identifierType, String identifierValue) {
        switch (identifierType) {
            case "ID":
                return driver.findElement(By.id(identifierValue));
            case "CSS":
                return driver.findElement(By.cssSelector(identifierValue));
            case "TAGNAME":
                return driver.findElement(By.tagName(identifierValue));
            case "XPATH":
                return driver.findElement(By.xpath(identifierValue));
            default:
                return null;
        }
    }

    public List<WebElement> getListWebElements(AppiumDriver driver, String identifierType, String identifierValue) {
        switch (identifierType) {
            case "ID":
                return driver.findElements(By.id(identifierValue));
            case "CSS":
                return driver.findElements(By.cssSelector(identifierValue));
            case "TAGNAME":
                return driver.findElements(By.tagName(identifierValue));
            case "XPATH":
                return driver.findElements(By.xpath(identifierValue));
            default:
                return null;
        }
    }
    
	public String park = "//android.view.View[@resource-id='auto_Park']",
			Rides = "//android.view.View[@resource-id='auto_Rides']",
			Passes = "//android.view.View[@resource-id='auto_Passes']",
			Map = "//android.view.View[@resource-id='auto_Map']",
			Dining = "//android.view.View[@resource-id='auto_Dining']",
			SlideOut = "//android.view.View[@resource-id='auto_HamburgerMenu']",
			Home = "//android.widget.TextView[@text='Six Flags Home']",
			SeeAllParks = "//android.widget.TextView[@text=See All Parks']";

}
