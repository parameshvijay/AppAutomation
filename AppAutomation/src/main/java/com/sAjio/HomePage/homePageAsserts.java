package com.sAjio.HomePage;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import commonRepo.CommonObjects;

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
}