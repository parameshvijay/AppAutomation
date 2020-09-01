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

public class CartBasic extends CommonObjects {

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
	public void sStaticSectionsInitialSetup() {
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
		methodHomeObj.clickAction(homeObj.lnkHamburgerMenu);
		methodHomeObj.clickAction(homeObj.lnkHamburgerPrimaryMenu);
		methodHomeObj.clickAction(homeObj.lnkHamburgerSecondaryMenu);
		methodHomeObj.clickAction(homeObj.lnkHamburgerFinalOption);
		methodHomeObj.clickAction(searchResultsObj.lnkSearchResultsFirstItemProductImage);
	}

	@Test(dependsOnMethods = "homePage")
	public void pdpSizeSelection() {
		double startPercentage = 0.25, endPercentage = 0.05;
		methodCommon.scrollDown(productDetailsObj.txtSimilarTo, startPercentage, endPercentage);
		productDetailsObj.lnkSizeNumber34.click();
	}

	@Test(dependsOnMethods = "pdpSizeSelection")
	public void pdpAddToCart() {
		methodHomeObj.clickAction(productDetailsObj.btnAddToBag, "Adding", productDetailsObj.btnAddToBag.getText());
		methodHomeObj.clickAction(productDetailsObj.btnAddToBag, productDetailsObj.txtHeaderNotification);
		methodHomeObj.clickAction(homeObj.lnkCancelAccountSelection, homeObj.lnkClosetSkip);
		methodHomeObj.clickAction(homeObj.lnkClosetSkip, productDetailsObj.btnSaveToCloset);
	}
}