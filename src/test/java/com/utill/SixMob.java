package com.utill;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.collect.ImmutableList;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class SixMob {
	static JavascriptExecutor js;
	String dining = "//android.view.View[@resource-id='auto_Passes']";

	private AppiumDriverLocalService service = null;
	int port = 4723;
	static AppiumDriver driver;

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	double SCROLL_RATIO = 0.41;

	String DeviceName = "emulator-5554";
	Duration SCROLL_DUR = Duration.ofMillis(500);

	public void startAppiumServer() {
		AppiumServiceBuilder builder = new AppiumServiceBuilder();
		builder.usingPort(port);
		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
		service.start();
		System.out.println("Server started");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("Server not started");
			e.printStackTrace();
		}
	}

	public void quitAppiumServer() {
		service.stop();
		System.out.println("Server Stopped");
	}

	public static void dinningPass() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement uploadpss = driver.findElement(By.xpath("//android.view.View[@resource-id='auto_UploadPass']"));
		js.executeScript("arguments[0].scrollIntoView(true);", uploadpss);
		uploadpss.click();
		WebElement manualEntry = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Enter number manually']")));
		manualEntry.click();
		WebElement enterPassNum = driver
				.findElement(By.xpath("//android.widget.EditText[@class='android.widget.EditText']"));
		// enterPassNum.click();
		enterPassNum.sendKeys("01040001233310000005");

		WebElement enter = driver.findElement(By.xpath("//android.view.View[@resource-id='auto_Proceed']"));
		enter.click();
		WebElement confirm = driver.findElement(By.xpath("//android.view.View[@index='10']"));
		confirm.click();

	}

	
	public void diningTab() throws Throwable {
		js = (JavascriptExecutor) driver;
		System.out.println("Test");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement dinningTab = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("\"//android.view.View[@resource-id='auto_Passes']")));
		js.executeScript("arguments[0].click();", dinningTab);

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

		dinningPass();

	}

	public enum ScrollDirection {
		UP, DOWN, LEFT, RIGHT
	}

	public void scroll(ScrollDirection dir, double scrollRatio) {

		if (scrollRatio < 0 || scrollRatio > 1) {
			throw new Error("Scroll distance must be between 0 and 1");
		}
		Dimension size = driver.manage().window().getSize();

		System.out.println(size);
		Point midPoint = new Point((int) (size.width * 0.5), (int) (size.height * 0.5));
		int bottom = midPoint.y + (int) (midPoint.y * scrollRatio);
		int top = midPoint.y - (int) (midPoint.y * scrollRatio);
		int left = midPoint.x - (int) (midPoint.x * scrollRatio);
		int right = midPoint.x + (int) (midPoint.x * scrollRatio);

		if (dir == ScrollDirection.UP) {
			swipe(new Point(midPoint.x, top), new Point(midPoint.x, bottom), SCROLL_DUR);
		} else if (dir == ScrollDirection.DOWN) {
			swipe(new Point(midPoint.x, bottom), new Point(midPoint.x, top), SCROLL_DUR);
		} else if (dir == ScrollDirection.LEFT) {
			swipe(new Point(left, midPoint.y), new Point(right, midPoint.y), SCROLL_DUR);
		} else if (dir == ScrollDirection.RIGHT) {
			swipe(new Point(right, midPoint.y), new Point(left, midPoint.y), SCROLL_DUR);
		} else {
			System.out.println("Enter the valid Scroll option");
		}
	}

	public void swipe(Point start, Point end, Duration duration) {

		PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		Sequence swipe = new Sequence(input, 0);
		swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
		swipe.addAction(input.createPointerDown(PointerInput.MouseButton.RIGHT.asArg()));
		swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
		swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(ImmutableList.of(swipe));

	}

	public void checktap() {
		System.out.println("Going to tap");
		Actions act = new Actions(driver);
		act.moveByOffset(170, 200).click().perform();
	}

}
