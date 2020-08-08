package com.sAjio.productDetailsPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class productDetailsPageObjects {

	@FindBy(id = "com.ril.ajio:id/product_img")
	public WebElement imgProductDetailsPage;

	@FindBy(id = "com.ril.ajio:id/pdp_toolbar_imv_back")
	public WebElement icnNavigateBack;

	@FindBy(id = "com.ril.ajio:id/row_pdp_title_price_tv_brand")
	public WebElement txtPDPBrandName;

	@FindBy(id = "com.ril.ajio:id/row_pdp_title_price_tv_info")
	public WebElement txtPDPProductName;

	@FindBy(id = "com.ril.ajio:id/row_pdp_title_price_tv_price")
	public WebElement txtPDPProductActualPrice;

	@FindBy(id = "com.ril.ajio:id/row_pdp_title_price_tv_old_price")
	public WebElement txtPDPProductOriginalPrice;
}