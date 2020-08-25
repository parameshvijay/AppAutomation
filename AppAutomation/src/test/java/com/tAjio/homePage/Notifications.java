package com.tAjio.homePage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sAjio.CommonRepo.CommonMethods;
import com.sAjio.CommonRepo.CommonObjects;
import com.sAjio.HomePage.homePageAsserts;
import com.sAjio.HomePage.homePageMethods;
import com.sAjio.HomePage.homePageObjects;
import com.sAjio.productDetailsPage.productDetailsPageAsserts;
import com.sAjio.productDetailsPage.productDetailsPageMethods;
import com.sAjio.productDetailsPage.productDetailsPageObjects;
import com.sAjio.searchResultPage.searchResultsPageAsserts;
import com.sAjio.searchResultPage.searchResultsPageMethods;
import com.sAjio.searchResultPage.searchResultsPageObjects;

public class Notifications extends CommonObjects {

	// Object declaration for Methods
	homePageMethods methodHomeObj;
	searchResultsPageMethods methodSearchResultsObj;
	CommonMethods methodCommon;
	productDetailsPageMethods methodProductDetailsPageObj;

	homePageObjects homeObj;
	searchResultsPageObjects searchResultsObj;
	productDetailsPageObjects productDetailsObj;

	// Object declaration for Asserts
	homePageAsserts assertHomeObj;
	searchResultsPageAsserts assertSearchResultsObj;
	productDetailsPageAsserts assertProductDetailsPageObj;

	@BeforeClass
	public void sHamburgerMenuInitialSetup() {
		methodHomeObj = new homePageMethods();
		methodSearchResultsObj = new searchResultsPageMethods();
		methodCommon = new CommonMethods();
		methodProductDetailsPageObj = new productDetailsPageMethods();

		assertHomeObj = new homePageAsserts();
		assertSearchResultsObj = new searchResultsPageAsserts();
		assertProductDetailsPageObj = new productDetailsPageAsserts();

		homeObj = new homePageObjects();
		searchResultsObj = new searchResultsPageObjects();
		productDetailsObj = new productDetailsPageObjects();

		homeObj = PageFactory.initElements(CommonObjects.driver, homePageObjects.class);
		searchResultsObj = PageFactory.initElements(CommonObjects.driver, searchResultsPageObjects.class);
		productDetailsObj = PageFactory.initElements(CommonObjects.driver, productDetailsPageObjects.class);
	}

	@Test(priority = 1)
	public void homePage() throws InterruptedException {
		methodHomeObj.homePageNavigation();
		// assertHomeObj.assertHomePageText();
	}

	@Test(dependsOnMethods = "homePage")
	public void notificationSection() {
		methodHomeObj.clickAction(homeObj.lnkNotificationIcon);
		assertHomeObj.validateNotificationScreen();
	}
}