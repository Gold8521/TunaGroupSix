package com.pageEvents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class mayaCinema {
	static WebDriver driver;

	public static void main(String[] args) throws Throwable {

		driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Actions actions = new Actions(driver);
		driver.manage().window().maximize();
		driver.get("https://mayacinemas.thetunagroup.com/");
		driver.findElement(By.linkText("Sign In")).click();
	
		driver.findElement(By.xpath("(//input[@name='username'])[2]")).sendKeys("1231231230");
		actions.sendKeys(Keys.TAB).sendKeys("5424180279791765")
		.sendKeys(Keys.TAB)
		.sendKeys(Keys.ENTER)
		.build().perform();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//div[@class='error']//p[1]")).getText();
		WebElement popup = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='error']//p[1]")));
		
		System.out.println("Error Pop up - " +popup.getText());
		System.out.println("Title of hte page - " +driver.getTitle());
		Thread.sleep(2000);
		driver.quit();

	}

}
