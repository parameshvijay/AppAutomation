package com.sAjio.productDetailsPage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.sAjio.CommonRepo.CommonMethods;
import com.sAjio.CommonRepo.CommonObjects;
import com.sAjio.searchResultPage.searchResultsPageMethods;
import com.sAjio.searchResultPage.searchResultsPageObjects;

public class productDetailsPageMethods extends searchResultsPageMethods {

	public static productDetailsPageObjects productDetailsObj;
	searchResultsPageObjects searchResultsObj;
	productDetailsPageAsserts assertProductDetailsPageObj;
	CommonMethods comMethods = new CommonMethods();

	public productDetailsPageMethods() {
		productDetailsObj = PageFactory.initElements(CommonObjects.driver, productDetailsPageObjects.class);
		searchResultsObj = PageFactory.initElements(CommonObjects.driver, searchResultsPageObjects.class);
		assertProductDetailsPageObj = new productDetailsPageAsserts();
		comMethods = new CommonMethods();
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

		String sBrandName = driver.findElement(By.xpath(searchResultsObj.slnkSearchResultsProductBrandName + "[1]"))
				.getText();
		driver.findElement(By.xpath(searchResultsObj.slnkSearchResultsProductBrandName + "[1]")).click();

		comMethods.clickAction(productDetailsObj.icnSizeChart);
		wait.until(ExpectedConditions.visibilityOf(productDetailsObj.txtSizeGuide));

		String sBrandNameInSizeChart = productDetailsObj.txtBrandName.getText();
		sBrandNameInSizeChart = sBrandNameInSizeChart.substring(8);

		assertProductDetailsPageObj.validateBrandInSizeChart(sBrandName, sBrandNameInSizeChart);
	}
}