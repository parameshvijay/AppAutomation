package com.sAjio.HomePage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import commonRepo.CommonObjects;
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

	public boolean checkHomePageText() {
		wait.until(ExpectedConditions.elementToBeClickable(homePageObj.lnkAjioMania));
		if (homePageObj.lnkAjioMania.getText().equalsIgnoreCase("Ajio"))
			return true;
		else
			return false;
	}

	public boolean validateMenuContent() {
		wait.until(ExpectedConditions.elementToBeClickable(homePageObj.lnkHamburgerMenuLogo));

		List<String> comparison = new ArrayList<String>();
		comparison.clear();
		List<MobileElement> actualMenuList = driver.findElements(By.xpath(homePageObj.txtHamburgerMenuItems));
		for (WebElement e : actualMenuList)
			comparison.add(e.getText());
		System.out.println(homePageObj.sExpectedMenuItems);
		System.out.println(comparison);

		if (comparison.equals(homePageObj.sExpectedMenuItems))
			return true;
		else
			return false;
	}
}