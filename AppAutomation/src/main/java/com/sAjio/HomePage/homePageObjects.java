package com.sAjio.HomePage;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePageObjects {

	public String txtHamburgerMenuItems = "//android.widget.ListView/android.widget.RelativeLayout/android.widget.TextView";

	List<String> sExpectedMenuItems = Arrays.asList("WOMEN", "MEN", "KIDS", "INDIE (The Artisan Store)", "STORES",
			"NEW ARRIVALS", "SALE", "COLLECTIONS");

	@FindBy(id = "com.ril.ajio:id/category_detailview_imv_one")
	public WebElement lnkAjioManiaHeader;

	@FindBy(id = "com.ril.ajio:id/toolbar_title")
	public WebElement lnkAjioMania;

	@FindBy(xpath = "//*[starts-with(@content-desc,'Open navigation drawer')]")
	public WebElement lnkHamburgerMenu;

	@FindBy(id = "com.ril.ajio:id/hnv_iv_brand")
	public WebElement lnkHamburgerMenuLogo;
}