package com.sAjio.HomePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.sAjio.CommonRepo.CommonObjects;
import com.sAjio.productDetailsPage.productDetailsPageObjects;

public class homePageMethods extends CommonObjects {

	homePageObjects homePageObj;
	productDetailsPageObjects productDetailsObj;

	public homePageMethods() {
		homePageObj = PageFactory.initElements(CommonObjects.driver, homePageObjects.class);
		productDetailsObj = PageFactory.initElements(CommonObjects.driver, productDetailsPageObjects.class);

		productDetailsObj = new productDetailsPageObjects();
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

	public void clickAction(WebElement e, String s, String s1) {
		wait.until(ExpectedConditions.visibilityOf(e));
		e.click();
		wait.until(ExpectedConditions.textToBePresentInElementValue(e, s));
		Assert.assertEquals(s1, "Product Added to bag successfully");
	}
}