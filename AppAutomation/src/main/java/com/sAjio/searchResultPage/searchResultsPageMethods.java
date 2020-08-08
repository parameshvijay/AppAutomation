package com.sAjio.searchResultPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.sAjio.CommonRepo.CommonObjects;
import com.sAjio.productDetailsPage.productDetailsPageAsserts;
import com.sAjio.productDetailsPage.productDetailsPageMethods;

import io.appium.java_client.MobileElement;

public class searchResultsPageMethods extends CommonObjects {

	searchResultsPageObjects searchResultsObj;
	productDetailsPageAsserts assertProductDetailsPageObj;

	public static HashMap<Integer, List<String>> productDetails = new HashMap<Integer, List<String>>();

	public searchResultsPageMethods() {
		searchResultsObj = PageFactory.initElements(CommonObjects.driver, searchResultsPageObjects.class);
	}

	public void searchDetailsFirstLevel() {
		wait.until(ExpectedConditions.elementToBeClickable(searchResultsObj.icnSearchResultsSort));
		// searchResultsObj.icnSearchResultsSort.click();
	}

	public void fetchProductDetails() {
		wait.until(ExpectedConditions.elementToBeClickable(searchResultsObj.searchResultsOverallContent));
		List<MobileElement> productInfo = driver
				.findElements(By.xpath(searchResultsObj.slnkSearchResultsProductsActualPrice));
		int productCount = productInfo.size();

		List<String> productDetailsSearchPage = new ArrayList<>();

		for (int i = 1; i <= productCount; i++) {
			wait.until(ExpectedConditions.elementToBeClickable(searchResultsObj.searchResultsOverallContent));
			productDetailsSearchPage.add(
					driver.findElement(By.xpath(searchResultsObj.slnkSearchResultsProductBrandName + "[" + i + "]"))
							.getText());
			productDetailsSearchPage.add(driver
					.findElement(By.xpath(searchResultsObj.slnkSearchResultsProductsName + "[" + i + "]")).getText());
			productDetailsSearchPage.add(
					driver.findElement(By.xpath(searchResultsObj.slnkSearchResultsProductsActualPrice + "[" + i + "]"))
							.getText());
			productDetailsSearchPage.add(driver
					.findElement(By.xpath(searchResultsObj.slnkSearchResultsProductsOriginalPrice + "[" + i + "]"))
					.getText());
			productDetails.put(i, productDetailsSearchPage);

			driver.findElement(By.xpath(searchResultsObj.slnkSearchResultsProductBrandName + "[" + i + "]")).click();
			List<String> pdpDetails = productDetailsPageMethods.getProductDetails();

			assertProductDetailsPageObj.validateCorrectness(pdpDetails, productDetailsSearchPage);
		}
	}
}