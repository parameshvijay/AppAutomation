package com.sAjio.HomePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePageObjects {

	@FindBy(id = "com.ril.ajio:id/category_detailview_imv_one")
	public WebElement lnkAjioManiaHeader;

	@FindBy(id = "com.ril.ajio:id/toolbar_title")
	public WebElement lnkAjioMania;
}