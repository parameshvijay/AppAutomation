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

	@FindBy(xpath = "//*[@text='in']")
	public WebElement txtSizeGuideMetricsInches;

	@FindBy(xpath = "//*[@text='cm']")
	public WebElement txtSizeGuideMetricsCentimeters;

	@FindBy(xpath = "//*[@text='inches']")
	public WebElement txtSizeGuideMetricsInchesSelection;

	@FindBy(xpath = "//*[@text='cm'][1]")
	public WebElement txtSizeGuideMetricsCentimetersSelection;

	@FindBy(xpath = "//*[@text='Brand Compare']")
	public WebElement secSizeGuideMetricsBrandCompare;

	@FindBy(xpath = "//*[@text='How to Measure']")
	public WebElement secSizeGuideMetricsHowToMeasure;

	@FindBy(xpath = "//android.widget.Image")
	public WebElement imgHowToMeasureImage;

	@FindBy(xpath = "//*[@text='Select a brand']")
	public WebElement secSizeGuideBrandSelection;

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

	@FindBy(id = "com.ril.ajio:id/pdp_toolbar_imv_closet")
	public WebElement icnClosetAtTop;

	@FindBy(id = "com.ril.ajio:id/pdp_toolbar_imv_cart")
	public WebElement icnCartAtTop;

	@FindBy(xpath = "//*[@resource-id='com.ril.ajio:id/toolbar']//android.widget.ImageButton")
	public WebElement icnCloseCart;

	@FindBy(id = "com.ril.ajio:id/row_pdp_circle_indicator")
	public WebElement icnProductImageScroller;

	@FindBy(id = "com.ril.ajio:id/view_pager_indicator")
	public WebElement icnProductZoomImageScroller;

	@FindBy(id = "com.ril.ajio:id/iv_zoomimage_lefticon")
	public WebElement icnProductZoomImageLeftScroll;

	@FindBy(id = "com.ril.ajio:id/iv_zoomimage_righticon")
	public WebElement icnProductZoomImageRightScroll;

	@FindBy(id = "com.ril.ajio:id/product_gallery_close")
	public WebElement icnProductZoomImageCloseView;

	@FindBy(id = "com.ril.ajio:id/view_pager_indicator")
	public WebElement icnProductZoomImageScrollIndicator;

	@FindBy(id = "com.ril.ajio:id/similar_prod_to")
	public WebElement txtSimilarTo;

	@FindBy(id = "com.ril.ajio:id/add_to_cart_layout_tv")
	public WebElement btnAddToBag;

	@FindBy(id = "com.ril.ajio:id/save_for_later_layout")
	public WebElement btnSaveToCloset;

	@FindBy(id = "com.ril.ajio:id/footer_pdp_btn_share")
	public WebElement secShareOptions;

	@FindBy(id = "com.huawei.android.internal.app:id/icon_area")
	public WebElement secSharingDetailedOptions;

	@FindBy(id = "com.whatsapp:id/toolbar")
	public WebElement txtWhatsAppToolbar;

	@FindBy(xpath = "//*[@resource-id='com.whatsapp:id/toolbar']/*[@content-desc = 'Navigate up']")
	public WebElement icnWhatsAppNavigateBack;

	@FindBy(xpath = "//*[@resource-id='android:id/text1' and @text='WhatsApp']")
	public WebElement icnWhatsApp;

	// ADDING PRODUCTS TO CART AND ITS RELEVANT OBJECTS
	@FindBy(id = "com.ril.ajio:id/notification_text")
	public WebElement txtHeaderNotification;
}