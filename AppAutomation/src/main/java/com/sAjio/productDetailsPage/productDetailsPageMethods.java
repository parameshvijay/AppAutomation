package com.sAjio.productDetailsPage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.sAjio.CommonRepo.CommonObjects;
import com.sAjio.searchResultPage.searchResultsPageMethods;

public class productDetailsPageMethods extends searchResultsPageMethods {

	public static productDetailsPageObjects productDetailsObj;
	// public static HashMap<Integer, String> pdpDetails = new HashMap<Integer,
	// String>();

	public productDetailsPageMethods() {
		productDetailsObj = PageFactory.initElements(CommonObjects.driver, productDetailsPageObjects.class);
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
}