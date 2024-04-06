package com.utill;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Testpack.SetupDriver;

import io.appium.java_client.AppiumDriver;

public class DinningBanner extends SetupDriver {

	static AppiumDriver driver;
	public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public static void parks() {
		WebElement parks = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@resource-id='auto_Park']")));
		parks.click();

	}

	public static void Rides() {
		WebElement rides = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//android.view.View[@resource-id='auto_Rides']")));
		rides.click();

	}

	public static void Passes() {
		WebElement passes = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//android.view.View[@resource-id='auto_Passes']")));
		passes.click();

	}

	public static  void Map() {
		WebElement map = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@resource-id='auto_Map']")));
		map.click();

	}

	public static void Dinning() {
		WebElement dinning = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//android.view.View[@resource-id='auto_Dining']")));
		dinning.click();

	}

	public  void HamburgerMenu() {
		System.out.println("Location Pointed");
		WebElement hamburgerMenu = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//android.view.View[@resource-id='auto_HamburgerMenu']")));
		hamburgerMenu.click();

	}
}
