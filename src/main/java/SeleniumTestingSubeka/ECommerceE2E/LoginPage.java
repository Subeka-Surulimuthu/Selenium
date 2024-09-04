package SeleniumTestingSubeka.ECommerceE2E;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import HelperFunctionpack.HelperFunction;

public class LoginPage extends HelperFunction {
	
	
	WebDriver driver;
	
	
	
	public LoginPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	

	@FindBy(id="userEmail") WebElement UserName;
	
	@FindBy(id="userPassword") WebElement password;
	
	@FindBy(id="login") WebElement loginButton;
	
	@FindBy(css="[class*='flyInOut']") WebElement errorMessage;
	
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
	public String getTheErrorOnInvalid() {
		
		visibilityofElementBasedonWebElement(errorMessage);
		return errorMessage.getText();
		
	}
	
	
	public ProductList loginOn(String user, String passwor) {
		
		UserName.sendKeys(user);
		password.sendKeys(passwor);
		loginButton.click();
		return new ProductList(driver);
		
	}
	
	
	
	
	

}
