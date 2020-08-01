package com.sAjio.CommonRepo;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.sAjio.searchResultPage.searchResultsPageObjects;

import io.appium.java_client.TouchAction;

public class CommonMethods extends CommonObjects {

	searchResultsPageObjects searchResultsObj;

	public CommonMethods() {
		searchResultsObj = PageFactory.initElements(CommonObjects.driver, searchResultsPageObjects.class);
	}

	@SuppressWarnings("rawtypes")
	public void scrollDown(WebElement element) throws InterruptedException {
		do {
			try {
				element.click();
			} catch (Exception e) {
				double anchorPercentage = 0.5, startPercentage = 0.8, endPercentage = 0.05;
				Dimension size = driver.manage().window().getSize();
				int anchor = (int) (size.width * anchorPercentage);
				int startPoint = (int) (size.height * startPercentage);
				int endPoint = (int) (size.height * endPercentage);

				new TouchAction(driver).press(point(anchor, startPoint)).waitAction(waitOptions(ofMillis(1000)))
						.moveTo(point(anchor, endPoint)).release().perform();
				Thread.sleep(10000);
			}
		} while (element.isDisplayed());
	}
}