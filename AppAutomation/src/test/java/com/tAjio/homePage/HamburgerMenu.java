package com.tAjio.homePage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sAjio.CommonRepo.CommonMethods;
import com.sAjio.CommonRepo.CommonObjects;
import com.sAjio.HomePage.homePageAsserts;
import com.sAjio.HomePage.homePageMethods;
import com.sAjio.HomePage.homePageObjects;
import com.sAjio.searchResultPage.searchResultsPageAsserts;
import com.sAjio.searchResultPage.searchResultsPageMethods;
import com.sAjio.searchResultPage.searchResultsPageObjects;

public class HamburgerMenu extends CommonObjects {

	// Object declaration for Methods
	homePageMethods methodHomeObj;
	searchResultsPageMethods methodSearchResultsObj;
	CommonMethods methodCommon;

	homePageObjects homeObj;
	searchResultsPageObjects searchResultsObj;

	// Object declaration for Asserts
	homePageAsserts assertHomeObj;
	searchResultsPageAsserts assertSearchResultsObj;

	@BeforeClass
	public void sHamburgerMenuInitialSetup() {
		methodHomeObj = new homePageMethods();
		methodSearchResultsObj = new searchResultsPageMethods();
		methodCommon = new CommonMethods();

		assertHomeObj = new homePageAsserts();
		assertSearchResultsObj = new searchResultsPageAsserts();

		homeObj = new homePageObjects();
		searchResultsObj = new searchResultsPageObjects();

		homeObj = PageFactory.initElements(CommonObjects.driver, homePageObjects.class);
		searchResultsObj = PageFactory.initElements(CommonObjects.driver, searchResultsPageObjects.class);

	}

	@Test(priority = 1)
	public void homePage() throws InterruptedException {
		methodHomeObj.hamburgerMenuLink();
		// assertHomeObj.assertHomePageText();
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
	public void productResultsPage() throws InterruptedException {
		methodSearchResultsObj.searchDetailsFirstLevel();
		double startPercentage = 0.15, endPercentage = 0.05;
		methodCommon.scrollDown(searchResultsObj.lnkSearchResultsThirdItem, startPercentage, endPercentage);
		methodSearchResultsObj.fetchProductDetails();
	}
}