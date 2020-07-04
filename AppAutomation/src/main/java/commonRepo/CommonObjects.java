package commonRepo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;

public class CommonObjects {

	public static DesiredCapabilities caps;
	public static WebDriverWait wait;
	public static AndroidDriver<WebElement> driver;

	@BeforeSuite
	public void setup() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Honor 9 Lite");
		caps.setCapability("udid", "9SF3Y18628012287"); // Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "9");
		caps.setCapability("noReset", "true");
		caps.setCapability("appPackage", "com.android.chrome");
		caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");

		driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4725/wd/hub"), caps);

		wait = new WebDriverWait(driver, 30);
		driver.get("https://www.flipkart.com/");
	}

	@AfterSuite
	public void closure() {
		driver.quit();
	}
}