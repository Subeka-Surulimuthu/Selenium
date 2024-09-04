package HelperFunctionpack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SeleniumTestingSubeka.ECommerceE2E.CheckOutPage;
import SeleniumTestingSubeka.ECommerceE2E.OrdersChecklist;

public class HelperFunction {
	
	WebDriver driver;
//	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(7));
	
	public HelperFunction(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']") WebElement orderButton;
	
	
	public OrdersChecklist clickONOrder() {
		visibilityofElementBasedonWebElement(orderButton);
		orderButton.click();
		OrdersChecklist oderPage=new OrdersChecklist(driver);
		return oderPage;
		
		
	}
	
	
	
	public void visibilityofAllElements(By locatot) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locatot));
	}
	
	public void visibilityofElementBasedonWebElement(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}
	
	public void waitONElementClick(By locator) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		
	}
	
	public void ScrollonPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollBy(0,100)");
	}
	
	public void waitUntilVisibility(By locator) {
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		
	}
	
	public void waitInvisiblity(By locator) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		
		
	}
	
	
	public CheckOutPage clickOnAddCart(WebElement element) {
		element.click();
		return new CheckOutPage(driver);
		
	}
	
	public void ScrollPageAndClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		js.executeScript("arguments[0].click();", element);
		
	}

}
