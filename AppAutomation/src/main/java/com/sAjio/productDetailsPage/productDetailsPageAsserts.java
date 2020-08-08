package com.sAjio.productDetailsPage;

import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.sAjio.CommonRepo.CommonObjects;

public class productDetailsPageAsserts extends CommonObjects {

	productDetailsPageObjects productDetailsObj;
	productDetailsPageMethods methodproductDetailsPageObj;

	public productDetailsPageAsserts() {
		productDetailsObj = PageFactory.initElements(CommonObjects.driver, productDetailsPageObjects.class);
		methodproductDetailsPageObj = PageFactory.initElements(CommonObjects.driver, productDetailsPageMethods.class);
	}

	public void validateCorrectness(List<String> pdpDetails, List<String> productDetailsSearchPage) {
		Assert.assertEquals(pdpDetails, productDetailsSearchPage);
	}
}