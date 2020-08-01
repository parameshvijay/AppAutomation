package com.sAjio.searchResultPage;

import org.openqa.selenium.support.PageFactory;

import com.sAjio.CommonRepo.CommonObjects;

public class searchResultsPageAsserts extends CommonObjects {

	searchResultsPageObjects searchResultsObj;
	searchResultsPageMethods methodSearchResultsObj;

	public searchResultsPageAsserts() {
		searchResultsObj = PageFactory.initElements(CommonObjects.driver, searchResultsPageObjects.class);
		methodSearchResultsObj = PageFactory.initElements(CommonObjects.driver, searchResultsPageMethods.class);
	}
}