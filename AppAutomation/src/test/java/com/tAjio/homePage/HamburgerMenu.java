package com.tAjio.homePage;

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
	}

	@Test(priority = 1)
	public void homePage() throws InterruptedException {
		methodHomeObj.checkHomePageCorrectness();
	}
}