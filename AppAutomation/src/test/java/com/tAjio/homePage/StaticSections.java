package com.tAjio.homePage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sAjio.CommonRepo.CommonMethods;
import com.sAjio.CommonRepo.CommonObjects;
import com.sAjio.HomePage.homePageAsserts;
import com.sAjio.HomePage.homePageMethods;
import com.sAjio.HomePage.homePageObjects;

public class StaticSections extends CommonObjects {

	// Object declaration for Methods
	homePageMethods methodHomeObj;
	CommonMethods methodCommon;

	homePageObjects homeObj;

	// Object declaration for Asserts
	homePageAsserts assertHomeObj;

	@BeforeClass
	public void sStaticSectionsInitialSetup() {
		methodHomeObj = new homePageMethods();
		methodCommon = new CommonMethods();

		assertHomeObj = new homePageAsserts();
		homeObj = new homePageObjects();

		homeObj = PageFactory.initElements(CommonObjects.driver, homePageObjects.class);
	}

	@Test(priority = 1)
	public void homePage() throws InterruptedException {
		methodHomeObj.homePageNavigation();
		// assertHomeObj.assertHomePageText();
	}

	@Test(dependsOnMethods = "homePage")
	public void notificationSection() {
		methodHomeObj.clickAction(homeObj.lnkNotificationIcon);
		assertHomeObj.validateScreenHeader("Notifications");
		methodHomeObj.clickAction(homeObj.icnNotificationBack);
	}

	@Test(dependsOnMethods = "notificationSection")
	public void footerSection() {
		methodHomeObj.clickAction(homeObj.icnStoresFooter, homeObj.txtPageHeader);
		assertHomeObj.validateScreenHeader("Stores");
		methodHomeObj.clickAction(homeObj.icnAccountFooter, homeObj.txtPageHeader);
		assertHomeObj.validateScreenHeader("My Account");
		methodHomeObj.clickAction(homeObj.icnClosetFooter, homeObj.lnkCancelAccountSelection);
		methodHomeObj.clickAction(homeObj.lnkCancelAccountSelection);
		methodHomeObj.clickAction(homeObj.btnFacebookLogin, homeObj.txtHeaderFacebookLandingPage);
		methodHomeObj.clickAction(homeObj.lnkFacebookBackNavigation, homeObj.btnFacebookLogin);
		methodHomeObj.clickAction(homeObj.lnkClosetSkip, homeObj.txtPageHeader);
		methodHomeObj.clickAction(homeObj.icnBagFooter, homeObj.txtPageHeader);
		assertHomeObj.validateScreenHeader("My Bag");
	}
}