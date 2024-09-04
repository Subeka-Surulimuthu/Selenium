package SeleniumTestingSubeka.ECommerceE2E;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import HelperFunctionpack.HelperFunction;

public class ProductList extends HelperFunction{
	
	
	WebDriver driver;
	
	ProductList(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	//driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
	
	@FindBy(css=".mb-3") List<WebElement> productList;
	@FindBy(css=".mb-3 button:last-child") WebElement AddCart;
	By locat=By.cssSelector(".mb-3");
	
	By toast=By.xpath("//div[@id='toast-container']");
	By toast1=By.cssSelector(".ng-animating");
	
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']") WebElement AddCartButton;
	
	
	
	public WebElement getProduct(String productName) {
		waitUntilVisibility(locat);
		
		WebElement prod=productList.stream().filter(product->product.findElement(By.cssSelector(".mb-3 b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		
		return prod;
		
	}
	
	public CheckOutPage AddToCart(String productName) {
		
		getProduct(productName).findElement(By.cssSelector(".mb-3 button:last-child")).click();
		waitUntilVisibility(toast);
		waitInvisiblity(toast1);
		CheckOutPage check=clickOnAddCart(AddCartButton);
		return check;
		
		
	}

	
	
	
	    
	
	
	

}
