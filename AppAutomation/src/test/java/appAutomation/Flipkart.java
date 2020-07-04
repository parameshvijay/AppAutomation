package appAutomation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Flipkart {

	static WebDriver driver;

	@BeforeClass
	public static void setup() throws InterruptedException {

		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Honor 9 Lite");
		caps.setCapability("udid", "9SF3Y18628012287"); // Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "9");
		caps.setCapability("appPackage", "com.flipkart.android");
		caps.setCapability("appActivity", ".activity.HomeFragmentHolderActivity");
		caps.setCapability("noReset", "true");

		// System.setProperty("webdriver.chrome.driver",
//				"C:\\Users\\ppadman1\\Drivers\\chromedriver_win32\\chromedriver.exe");

		// Instantiate Appium Driver
//		AppiumDriver<MobileElement> driver = null;

		try {
			driver = new RemoteWebDriver(new URL("http://0.0.0.0:4725/wd/hub"), caps);

		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void test() {

	}
}