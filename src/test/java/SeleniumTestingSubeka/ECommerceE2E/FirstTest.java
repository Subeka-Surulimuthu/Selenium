package SeleniumTestingSubeka.ECommerceE2E;


import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseTestingClass.BaseClass;

public class FirstTest extends BaseClass{
	
	String prodName="ZARA COAT 3";
	String uname="subisubi8@gmail.com";
	String password="Chithra@subi8";
	
	@Test(dataProvider="getdata", groups= {"End end Testing"})
	public  void ECommerceTesting(HashMap<String,String> input) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		String CountryName="india";
		
		ProductList prodl=landing.loginOn(input.get("email"), input.get("password"));
		CheckOutPage checko=prodl.AddToCart(input.get("prodName"));
	
		Boolean match=checko.getproductMatchOnCart(input.get("prodName"));
		Assert.assertTrue(match);
		PlaceOrder placeOrd=checko.doCheckOut();
		
		placeOrd.selectCountry(CountryName);
		Confirmation confo=placeOrd.placeTheOrder();
		String confirmation=confo.getConfo();

		Assert.assertTrue(confirmation.equalsIgnoreCase("Thankyou for the order."));
		
		
		
	}
	
	@Test(dependsOnMethods={"ECommerceTesting"})
	
	public void orderCheckListValidation() {
		
		ProductList pro=landing.loginOn(uname, password);
		OrdersChecklist orderPlaced=pro.clickONOrder();
		
		Assert.assertTrue(orderPlaced.getOrderCheckList(prodName));
		}
	
	@DataProvider
	public Object[][] getdata() throws IOException {
		
	List<HashMap<String,String>> datalist=getDataFromJson("C://Users//subek//eclipse-workspace//ECommerceE2E//src//test//java//ResourcesOnJson//data.json");
		
		return new Object[][] {{datalist.get(0)},{datalist.get(1)}};
		
	}
	
	
	
	

}
