package SeleniumTestingSubeka.ECommerceE2E;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import HelperFunctionpack.HelperFunction;

public class PlaceOrder extends HelperFunction{

	WebDriver driver;
	
	PlaceOrder(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@FindBy(xpath="//input[@placeholder='Select Country']") WebElement ContryField;
	
	@FindBy(css=".ta-results button:last-child") WebElement selectedContry;
	@FindBy(css=".ta-results button:last-child") WebElement contryindex;
	@FindBy(css=".action__submit") WebElement placeOrderbutton;
	
	
	
	By place=By.cssSelector(".action__submit");
	By result=By.cssSelector(".ta-results");
	By elementClick=By.cssSelector(".action__submit");
	
	public void selectCountry(String CountryName) {
		
		waitUntilVisibility(place);
		Actions a=new Actions(driver);
		a.sendKeys(ContryField, CountryName).build().perform();;
		visibilityofAllElements(result);
		ScrollonPage();
		waitONElementClick(elementClick);
		contryindex.click();
		
	}
	
	public Confirmation placeTheOrder() {
		ScrollPageAndClick(placeOrderbutton);
		return new Confirmation(driver);
	}
	
	
	
	
	
	
	
}
