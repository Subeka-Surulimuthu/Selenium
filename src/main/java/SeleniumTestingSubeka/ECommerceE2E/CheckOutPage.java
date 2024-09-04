package SeleniumTestingSubeka.ECommerceE2E;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import HelperFunctionpack.HelperFunction;

public class CheckOutPage extends HelperFunction{
	
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//List<WebElement> cartItems=driver.findElements(By.cssSelector(".cartSection h3"));
	
	@FindBy(css=".cartSection h3")  List<WebElement> cartItems;
	@FindBy(xpath="(//button[@class='btn btn-primary'])[3]") WebElement checkOutButton;
	
	
	public Boolean getproductMatchOnCart(String productName) {
		
		return cartItems.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		
		
		
	}
	
	public PlaceOrder doCheckOut() {
		ScrollPageAndClick(checkOutButton);
		return new PlaceOrder(driver);
		
	}
	

}
