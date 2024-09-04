package BaseTestingClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import SeleniumTestingSubeka.ECommerceE2E.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public LoginPage landing;
	
	public void test() {
		System.out.println("jenkins testing");
	}
	public WebDriver InitiateTheBrowser() throws IOException {
		
		
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C://Users//subek//eclipse-workspace//ECommerceE2E//src//main//java//Resources//global.properties");
		prop.load(fis);
		
		String browser=System.getProperty("browser")!=null?System.getProperty("browser"):prop.getProperty("browser");
	//	String browser=prop.getProperty("browser");
		
		if(browser.contains("chrome")) {
			ChromeOptions option=new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(browser.contains("headless")) {
			option.addArguments("headless");
			}
			driver=new ChromeDriver(option);
		}
		
		driver.manage().window().setSize(new Dimension(1440,900));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
		
		
	}
	
	public  List<HashMap<String, String>> getDataFromJson(String filepath) throws IOException {
		
		String jsonContent=	FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);
			ObjectMapper mapper=new ObjectMapper();
			
			List<HashMap<String,String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){
				
			});
			return data;
			
		}

	
	
	@BeforeMethod(alwaysRun=true)
	public LoginPage launchTheApp() throws IOException {
		driver=InitiateTheBrowser();
		
		landing=new LoginPage(driver);
		landing.goTo();
		return landing;
	}
	
	@AfterMethod(alwaysRun=true)
	public void close() {
		driver.close();
	}
	
public String getScreenShot(String testCaseNAme, WebDriver driver) throws IOException {
		
		TakesScreenshot ts=((TakesScreenshot)driver);
		File source=ts.getScreenshotAs(OutputType.FILE);
		String path="C:\\Users\\subek\\OneDrive\\Desktop\\Automation\\ExtentReports SS\\"+testCaseNAme+".png";
		File destination=new File("C:\\Users\\subek\\OneDrive\\Desktop\\Automation\\ExtentReports SS\\"+testCaseNAme+".png");
		FileUtils.copyFile(source, destination);
		return "C:\\Users\\subek\\OneDrive\\Desktop\\Automation\\ExtentReports SS\\"+testCaseNAme+".png";
		
	}
	

}
