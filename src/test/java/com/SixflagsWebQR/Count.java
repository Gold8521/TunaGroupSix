package com.SixflagsWebQR;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Count {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--window-size=" + 300 + "," + 800);
		WebDriver driver = new ChromeDriver(options);
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Actions actions = new Actions(driver);
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://sixflags.thetunagroup.com/order-by/1/qr-code");

		for (int i = 0; i < 100; i++) {
			
			WebElement homeFilter = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()=' Funnel Cakes']")));
			homeFilter.click();
			 Thread.sleep(1000);

			WebElement frenchFries = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//h3[text()='TG French Fries'])")));
			// ((JavascriptExecutor)
			// driver).executeScript("arguments[0].scrollIntoView(true);", frenchFries);
			frenchFries.click();
			 Thread.sleep(1000);

			WebElement addToCart = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.className("new_cart_btn")));
			addToCart.click();
			Thread.sleep(2000);
			WebElement viewCart = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//div[contains(@class,'new_cart_btn2 hidden_c_item')]")));
			viewCart.click();
			 Thread.sleep(1000);
			driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();
			 Thread.sleep(1000);
			driver.findElement(By.xpath("//a[contains(text(),'Proceed to Pay')]")).click();
			 Thread.sleep(1000);
			driver.findElement(By.id("customer_name")).sendKeys("Gold");
			 Thread.sleep(1000);
			driver.findElement(By.id("phone_number")).sendKeys("8072887785");
			 Thread.sleep(1000);

			WebElement submit = driver.findElement(By.xpath("//button[text()='Continue']"));
			 Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submit);
			Thread.sleep(1000);
			submit.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[contains(text(),'Credit Card')]")).click();
			Thread.sleep(2000);
			System.out.println("Page Info" + driver.getTitle());
			driver.findElement(By.id("nameOnCard")).sendKeys("Gold");
			 Thread.sleep(1000);
			actions.sendKeys(Keys.TAB).sendKeys("5424180279791765").sendKeys(Keys.TAB).sendKeys("1234")
					.sendKeys(Keys.TAB).sendKeys("123").sendKeys(Keys.TAB).sendKeys("641652").sendKeys(Keys.TAB)
					.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(3000);
			System.out.println("User Number-" + i + "//order id-" + driver.findElement(By.xpath("//div[@class='order_idBox text-center']//h3[1]")).getText());
			
			driver.findElement(By.xpath("//a[contains(text(),'Go Home')]")).click();
			 Thread.sleep(3000);
		}
		driver.quit();
	}

}
