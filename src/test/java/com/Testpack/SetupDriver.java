package com.Testpack;

import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class SetupDriver {

	protected static AppiumDriver driver;
	static AppiumDriverLocalService service;
@Test
	public static AppiumDriver initDriver() throws Exception {
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android").setDeviceName("emulator-5554").setPlatformVersion("13.0")
				.setAppPackage("com.sixflags.android.snapshot").setAppActivity("com.sixflags.android.MainActivity")
				.setNoReset(true).setEnsureWebviewsHavePages(true).setAutomationName("UIAutomator2")
				.setNewCommandTimeout(Duration.ofSeconds(20)).setNoReset(true);
		service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingAnyFreePort());
		service.start();
		URI uri = new URI(service.getUrl().toString());
		URL url = uri.toURL();
		driver = new AppiumDriver(url, options);
		return driver;

	}

	
	public static void teardown() {
		driver.quit();
		service.stop();
	}


}
