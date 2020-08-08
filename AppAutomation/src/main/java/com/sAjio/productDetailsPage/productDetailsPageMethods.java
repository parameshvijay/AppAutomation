package com.sAjio.productDetailsPage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.sAjio.CommonRepo.CommonObjects;
import com.sAjio.searchResultPage.searchResultsPageMethods;
import com.sAjio.searchResultPage.searchResultsPageObjects;

public class productDetailsPageMethods extends searchResultsPageMethods {

	public static productDetailsPageObjects productDetailsObj;
	searchResultsPageObjects searchResultsObj;

	public productDetailsPageMethods() {
		productDetailsObj = PageFactory.initElements(CommonObjects.driver, productDetailsPageObjects.class);
		searchResultsObj = PageFactory.initElements(CommonObjects.driver, searchResultsPageObjects.class);
	}

	public static List<String> getProductDetails() {
		wait.until(ExpectedConditions.visibilityOf(productDetailsObj.imgProductDetailsPage));

		List<String> pdpDetails = new ArrayList<>(4);
		pdpDetails.add(productDetailsObj.txtPDPBrandName.getText());
		pdpDetails.add(productDetailsObj.txtPDPProductName.getText());
		pdpDetails.add(productDetailsObj.txtPDPProductActualPrice.getText());
		pdpDetails.add(productDetailsObj.txtPDPProductOriginalPrice.getText());

		productDetailsObj.icnNavigateBack.click();
		return pdpDetails;
	}

	public void checkPDPCorrectness() {
		wait.until(ExpectedConditions.elementToBeClickable(searchResultsObj.searchResultsOverallContent));
		driver.findElement(By.xpath(searchResultsObj.slnkSearchResultsProductBrandName + "[1]")).click();

		wait.until(ExpectedConditions.elementToBeClickable(productDetailsObj.icnSizeChart));
		productDetailsObj.icnSizeChart.click();
		wait.until(ExpectedConditions.elementToBeClickable(productDetailsObj.txtSizeGuide));
	}
}