package com.Testpack;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;

public class BaseTest {

			static JavascriptExecutor js;
			static AppiumDriver driver;
			static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			Duration timeout = Duration.ofSeconds(120);
		
			public void diningTab() throws Throwable {
		
				js = (JavascriptExecutor) driver;
				System.out.println("Test");
				Thread.sleep(5000);
				WebElement Passes = wait.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//android.view.View[@resource-id='auto_Passes']")));
				Passes.click();
				Thread.sleep(2000);
				WebElement OffMobOrder = wait
						.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@index='5']")));
				OffMobOrder.click();
				Thread.sleep(2000);
				WebElement dinningpass = wait
						.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@index='7']")));
				dinningpass.click();
				WebElement park = driver.findElement(By.xpath("//android.view.View[@resource-id='auto_Park']"));
				park.click();
				Thread.sleep(2000);
			}
		
			public static void dinningPass() throws Throwable {
				System.out.println("Test");
				Thread.sleep(5000);
				WebElement Passes = wait.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//android.view.View[@resource-id='auto_Passes']")));
				js.executeScript("arguments[0].click();", Passes);
				WebElement uploadpss = driver.findElement(By.xpath("//android.view.View[@resource-id='auto_UploadPass']"));
				js.executeScript("arguments[0].scrollIntoView(true);", uploadpss);
				uploadpss.click();
				WebElement manualEntry = wait.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Enter number manually']")));
				manualEntry.click();
				WebElement enterPassNum = driver
						.findElement(By.xpath("//android.widget.EditText[@class='android.widget.EditText']"));
				enterPassNum.sendKeys("01040001233310000005");
				WebElement enter = driver.findElement(By.xpath("//android.view.View[@resource-id='auto_Proceed']"));
				enter.click();
				WebElement confirm = driver.findElement(By.xpath("//android.view.View[@index='10']"));
				confirm.click();
			}
		
		}
