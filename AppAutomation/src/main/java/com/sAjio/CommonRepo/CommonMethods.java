package com.sAjio.CommonRepo;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.sAjio.searchResultPage.searchResultsPageObjects;

import io.appium.java_client.TouchAction;

public class CommonMethods extends CommonObjects {

	searchResultsPageObjects searchResultsObj;

	public CommonMethods() {
		searchResultsObj = PageFactory.initElements(CommonObjects.driver, searchResultsPageObjects.class);
	}

	@SuppressWarnings("rawtypes")
	public void scrollDown(WebElement element, double sPercentage, double ePercentage) {
		for (int i = 0; i >= 0; i++)
			try {
				if (element.isDisplayed())
					break;
			} catch (Exception e) {
				double anchorPercentage = 0.5;
				Dimension size = driver.manage().window().getSize();
				int anchor = (int) (size.width * anchorPercentage);
				int startPoint = (int) (size.height * sPercentage);
				int endPoint = (int) (size.height * ePercentage);

				new TouchAction(driver).press(point(anchor, startPoint)).waitAction(waitOptions(ofMillis(1000)))
						.moveTo(point(anchor, endPoint)).release().perform();
			}
	}

	public void clickAction(WebElement e) {
		wait.until(ExpectedConditions.visibilityOf(e));
		e.click();
	}
}