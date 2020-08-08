package com.sAjio.searchResultPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class searchResultsPageObjects {

	@FindBy(id = "com.ril.ajio:id/plp_sort_checkbox")
	public WebElement icnSearchResultsSort;

	@FindBy(id = "com.ril.ajio:id/parent_layout")
	public WebElement searchResultsOverallContent;

	@FindBy(xpath = "(//*[@resource-id='com.ril.ajio:id/item_price'])[3]")
	public WebElement lnkSearchResultsThirdItem;

	public String slnkSearchResultsProductsActualPrice = "(//*[@resource-id='com.ril.ajio:id/item_price'])";
	public String slnkSearchResultsProductsName = "(//*[@resource-id='com.ril.ajio:id/item_name'])";
	public String slnkSearchResultsProductsOriginalPrice = "(//*[@resource-id='com.ril.ajio:id/item_old_price'])";
	public String slnkSearchResultsProductBrandName = "(//*[@resource-id='com.ril.ajio:id/item_brand'])";
}