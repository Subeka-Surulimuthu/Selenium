package SeleniumTestingSubeka.ECommerceE2E;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import HelperFunctionpack.HelperFunction;

public class Confirmation extends HelperFunction{
	
	WebDriver driver;
	
	Confirmation(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(css=".hero-primary") WebElement confotext;
	
	public String getConfo() {
		
		return confotext.getText();
		
	}
	
	

}
