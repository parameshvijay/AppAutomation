package com.sAjio.CommonRepo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CommonObjects {

	public static DesiredCapabilities caps;
	public static WebDriverWait wait;
	public static AndroidDriver<MobileElement> driver;

	@BeforeClass
	public static void setup() throws InterruptedException {

		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Honor 9 Lite");
		caps.setCapability("udid", "9SF3Y18628012287"); // Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "9");
		caps.setCapability("appPackage", "com.ril.ajio");
		caps.setCapability("appActivity", "com.ril.ajio.home.category.activity.HomeCategoryActivity");
		caps.setCapability("noReset", "true");

		try {
			driver = new AndroidDriver<>(new URL("http://0.0.0.0:4725/wd/hub"), caps);

		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}

		wait = new WebDriverWait(driver, 30);
	}

	@AfterSuite
	public void closure() {
		driver.quit();
	}
}