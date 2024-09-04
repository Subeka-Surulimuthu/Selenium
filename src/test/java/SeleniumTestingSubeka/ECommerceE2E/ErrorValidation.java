package SeleniumTestingSubeka.ECommerceE2E;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTestingClass.BaseClass;

public class ErrorValidation extends BaseClass {
	
	@Test(groups= {"Error Validation"},retryAnalyzer=BaseTestingClass.Retry.class)
	public void ErrorValidationOnUserName() throws IOException {
		
	//	LoginPage landing=launchTheApp();
		landing.loginOn("subisubi8@gmail.com", "Chithra@ubi8");
		
		String ExpectedRe=landing.getTheErrorOnInvalid();
		Assert.assertEquals(ExpectedRe, "Incorrect email or password.");;
		
		
	}
	
	
	@Test
	
	public void productErrorValidation() {
		
		
		String prodName="ZARA COAT 3";
		String uname="subisubishivan8@gmail.com";
		String password="Chithra@subi8";
		
		
		ProductList prodl=landing.loginOn(uname, password);
		CheckOutPage checko=prodl.AddToCart(prodName);
	
		Boolean match=checko.getproductMatchOnCart(prodName);
		Assert.assertTrue(match);
	}
	
	
	
	
	

}
