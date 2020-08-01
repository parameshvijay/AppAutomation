package com.sAjio.searchResultPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.sAjio.CommonRepo.CommonObjects;

import io.appium.java_client.MobileElement;

public class searchResultsPageMethods extends CommonObjects {

	searchResultsPageObjects searchResultsObj;

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

		List<String> ProductDetails = new ArrayList<>();

		for (int i = 1; i <= productCount; i++) {
			HashMap<Integer, List<String>> hmap = new HashMap<Integer, List<String>>();
			ProductDetails.add(
					driver.findElement(By.xpath(searchResultsObj.slnkSearchResultsProductBrandName + "[" + i + "]"))
							.getText());
			ProductDetails.add(driver
					.findElement(By.xpath(searchResultsObj.slnkSearchResultsProductsName + "[" + i + "]")).getText());
			ProductDetails.add(
					driver.findElement(By.xpath(searchResultsObj.slnkSearchResultsProductsActualPrice + "[" + i + "]"))
							.getText());
			ProductDetails.add(driver
					.findElement(By.xpath(searchResultsObj.slnkSearchResultsProductsOriginalPrice + "[" + i + "]"))
					.getText());
			hmap.put(i, ProductDetails);
			System.out.println(hmap);
		}
	}
}