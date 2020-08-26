package com.sAjio.HomePage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.sAjio.CommonRepo.CommonObjects;

import io.appium.java_client.MobileElement;

public class homePageAsserts extends CommonObjects {

	homePageObjects homePageObj;
	homePageMethods homePageMet;

	public homePageAsserts() {
		homePageObj = PageFactory.initElements(CommonObjects.driver, homePageObjects.class);
		homePageMet = PageFactory.initElements(CommonObjects.driver, homePageMethods.class);
	}

	public boolean assertHomePage() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(homePageObj.lnkAjioMania));
		if (homePageObj.lnkAjioMania.isDisplayed())
			return true;
		else
			return false;
	}

	public void assertHomePageText() {
		wait.until(ExpectedConditions.elementToBeClickable(homePageObj.lnkAjioMania));
		Assert.assertEquals(homePageObj.lnkAjioMania.getText(), "AJIO");
	}

	public void validateMenuContent() {
		wait.until(ExpectedConditions.elementToBeClickable(homePageObj.lnkHamburgerMenuLogo));

		List<String> comparison = new ArrayList<String>();
		comparison.clear();
		List<MobileElement> actualMenuList = driver.findElements(By.xpath(homePageObj.txtHamburgerMenuItems));
		for (WebElement e : actualMenuList)
			comparison.add(e.getText());
		Assert.assertEquals(comparison, homePageObj.sExpectedMenuItems);
	}

	public void validateScreenHeader(String s) {
		wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOf(homePageObj.imgEmptyNotification),
				ExpectedConditions.visibilityOf(homePageObj.txtPageHeader)));
		String sHeaderText = homePageObj.txtPageHeader.getText();
		Assert.assertEquals(sHeaderText, s);
	}
}