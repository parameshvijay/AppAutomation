package com.sAjio.searchResultPage;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.sAjio.CommonRepo.CommonObjects;

public class searchResultsPageMethods extends CommonObjects {

	searchResultsPageObjects searchResultsObj;

	public searchResultsPageMethods() {
		searchResultsObj = PageFactory.initElements(CommonObjects.driver, searchResultsPageObjects.class);
	}

	public void searchDetailsFirstLevel() {
		wait.until(ExpectedConditions.elementToBeClickable(searchResultsObj.icnSearchResultsSort));
		searchResultsObj.icnSearchResultsSort.click();
	}

	public void fetchProductDetails() {
		wait.until(ExpectedConditions.elementToBeClickable(searchResultsObj.searchResultsOverallContent));

	}
}