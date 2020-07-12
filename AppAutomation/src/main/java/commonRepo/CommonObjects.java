package commonRepo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class CommonObjects {

	public static DesiredCapabilities caps;
	public static WebDriverWait wait;
	public static RemoteWebDriver driver;

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

		try {
			driver = new RemoteWebDriver(new URL("http://0.0.0.0:4725/wd/hub"), caps);

		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
	}

	@AfterSuite
	public void closure() {
		driver.quit();
	}
}