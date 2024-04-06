package com.machuHealth;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteUser {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://104.248.14.14/macuhealth-web/public/macu-admin");
		driver.findElement(By.id("username")).sendKeys("admin@macuhealth.com");
		driver.findElement(By.id("password")).sendKeys("Tuna@Macu112023!");
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.xpath("//span[text()='Subscribers']")).click();
		for (int i =0;i<128;i++) {
		driver.findElement(By.xpath("(//a[@title='Delete'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		Thread.sleep(2000);
		}
		
	}

}
