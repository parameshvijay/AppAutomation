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

public class PDPBasic extends CommonObjects {

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
	public void pdpStaticElements_Closet() {
		methodHomeObj.clickAction(productDetailsObj.icnClosetAtTop, homeObj.lnkCancelAccountSelection);
		methodHomeObj.clickAction(homeObj.lnkCancelAccountSelection);
//		methodHomeObj.clickAction(homeObj.btnFacebookLogin, homeObj.txtHeaderFacebookLandingPage);
//		methodHomeObj.clickAction(homeObj.secContentPage, homeObj.btnFacebookLogin);
		// methodHomeObj.clickAction(homeObj.lnkFacebookBackNavigation,
		// homeObj.btnFacebookLogin);
		methodHomeObj.clickAction(homeObj.lnkClosetSkip, productDetailsObj.icnSizeChart);
	}

	@Test(dependsOnMethods = "pdpStaticElements_Closet")
	public void pdpStaticElements_Cart() {
		methodHomeObj.clickAction(productDetailsObj.icnCartAtTop, homeObj.txtPageHeader);
		assertHomeObj.validateScreenHeader("My Bag");
		methodHomeObj.clickAction(productDetailsObj.icnCloseCart, productDetailsObj.icnSizeChart);
	}

	@Test(dependsOnMethods = "pdpStaticElements_Cart")
	public void pdpProductImageScroll() throws InterruptedException {
		double startPercentage = 0.35, endPercentage = 0.05;
		int scrollCount = 3;
		methodCommon.scrollRight(productDetailsObj.imgProductDetailsPage, startPercentage, endPercentage, scrollCount);
	}

	@Test(dependsOnMethods = "pdpProductImageScroll")
	public void pdpProductImageZoomView() {
		methodHomeObj.clickAction(productDetailsObj.imgProductDetailsPage,
				productDetailsObj.icnProductZoomImageScroller);
		methodHomeObj.clickAction(productDetailsObj.icnProductZoomImageLeftScroll,
				productDetailsObj.icnProductZoomImageRightScroll);
		methodHomeObj.clickAction(productDetailsObj.icnProductZoomImageRightScroll,
				productDetailsObj.icnProductZoomImageLeftScroll);
		methodHomeObj.clickAction(productDetailsObj.icnProductZoomImageCloseView,
				productDetailsObj.imgProductDetailsPage);
	}

	@Test(dependsOnMethods = "pdpProductImageZoomView")
	public void pdpAddToCart() {
		double startPercentage = 0.25, endPercentage = 0.05;
		methodCommon.scrollDown(productDetailsObj.txtSimilarTo, startPercentage, endPercentage);
		productDetailsObj.lnkSizeNumber34.click();
	}

	@Test(dependsOnMethods = "pdpAddToCart")
	public void pdpSaveToCloset() {
		methodHomeObj.clickAction(productDetailsObj.btnSaveToCloset, homeObj.lnkCancelAccountSelection);
		methodHomeObj.clickAction(homeObj.lnkCancelAccountSelection, homeObj.lnkClosetSkip);
		methodHomeObj.clickAction(homeObj.lnkClosetSkip, productDetailsObj.btnSaveToCloset);
	}

	@Test(dependsOnMethods = "pdpSaveToCloset")
	public void pdpShareOptions() {
		methodHomeObj.clickAction(productDetailsObj.secShareOptions, productDetailsObj.secSharingDetailedOptions);
		assertProductDetailsPageObj.validateSharingOptions();
		methodHomeObj.clickAction(productDetailsObj.icnWhatsApp, productDetailsObj.txtWhatsAppToolbar);
		methodHomeObj.clickAction(productDetailsObj.icnWhatsAppNavigateBack, productDetailsObj.secShareOptions);
	}
}