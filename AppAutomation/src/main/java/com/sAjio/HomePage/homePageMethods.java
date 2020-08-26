package com.sAjio.HomePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.sAjio.CommonRepo.CommonObjects;

public class homePageMethods extends CommonObjects {

	homePageObjects homePageObj;

	public homePageMethods() {
		homePageObj = PageFactory.initElements(CommonObjects.driver, homePageObjects.class);
	}

	public void homePageNavigation() {
		wait.until(ExpectedConditions.visibilityOf(homePageObj.lnkAjioManiaHeader));
		homePageObj.lnkAjioManiaHeader.click();
		wait.until(ExpectedConditions.visibilityOf(homePageObj.lnkAjioMania));
	}

	public void clickAction(WebElement e) {
		wait.until(ExpectedConditions.visibilityOf(e));
		e.click();
	}

	public void clickAction(WebElement e, WebElement eTarget) {
		wait.until(ExpectedConditions.visibilityOf(e));
		e.click();
		wait.until(ExpectedConditions.visibilityOf(eTarget));
	}
}