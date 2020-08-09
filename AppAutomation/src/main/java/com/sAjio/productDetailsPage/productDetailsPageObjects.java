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

	@FindBy(id = "com.ril.ajio:id/row_pdp_tv_size")
	public WebElement icnSizeChart;

	@FindBy(id = "com.ril.ajio:id/toolbar_title")
	public WebElement txtSizeGuide;

	@FindBy(xpath = "//*[@content-desc='Navigate up']")
	public WebElement icnNavigateBackSizeChart;

	@FindBy(xpath = "//android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[1]")
	public WebElement txtBrandName;

	@FindBy(id = "com.ril.ajio:id/goto_size_guide_button")
	public WebElement lnkCheckSizeChart;

	@FindBy(xpath = "//*[@resource-id='com.ril.ajio:id/row_pdp_fixed_size_tv' and @text='34']")
	public WebElement lnkSizeNumber34;

	@FindBy(id = "com.ril.ajio:id/pdp_size_info_tv_header")
	public WebElement txtSizeNumberHeader;

	@FindBy(id = "com.ril.ajio:id/pdp_size_info_tv_text")
	public WebElement txtSizeNumber;
}