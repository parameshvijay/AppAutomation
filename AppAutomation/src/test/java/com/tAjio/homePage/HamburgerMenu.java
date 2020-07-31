package com.tAjio.homePage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sAjio.HomePage.homePageAsserts;
import com.sAjio.HomePage.homePageMethods;
import com.sAjio.HomePage.homePageObjects;

import commonRepo.CommonObjects;

public class HamburgerMenu extends CommonObjects {

	// Object declaration for Methods
	homePageMethods methodHomeObj;
	homePageObjects homeObj;

	// Object declaration for Asserts
	homePageAsserts assertHomeObj;

	@BeforeClass
	public void sHamburgerMenuInitialSetup() {
		methodHomeObj = new homePageMethods();
		assertHomeObj = new homePageAsserts();
		homeObj = new homePageObjects();
		homeObj = PageFactory.initElements(CommonObjects.driver, homePageObjects.class);
	}

	@Test(priority = 1)
	public void homePage() throws InterruptedException {
		methodHomeObj.hamburgerMenuLink();
		assertHomeObj.assertHomePageText();
	}

	@Test(dependsOnMethods = "homePage")
	public void hamburgerMenuTap() {
		methodHomeObj.clickAction(homeObj.lnkHamburgerMenu);
		assertHomeObj.validateMenuContent();
	}

	@Test(dependsOnMethods = "hamburgerMenuTap")
	public void secondaryMenuTap() {
		methodHomeObj.clickAction(homeObj.lnkHamburgerPrimaryMenu);
		methodHomeObj.clickAction(homeObj.lnkHamburgerSecondaryMenu);
		methodHomeObj.clickAction(homeObj.lnkHamburgerFinalOption);
	}

	@Test(dependsOnMethods = "secondaryMenuTap")
	public void productCatalogPage() throws InterruptedException {
		Thread.sleep(5000);
	}
}