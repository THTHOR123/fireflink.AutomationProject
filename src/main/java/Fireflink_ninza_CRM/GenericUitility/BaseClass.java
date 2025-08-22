package Fireflink_ninza_CRM.GenericUitility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Fireflink_ninza_CRM.objectRepository.DashboardPage;
import Fireflink_ninza_CRM.objectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class consists of basic configuration annotations
 * @author Tushar Jadhav
 */
public class BaseClass {
	
	public FileUtility fUtil = new FileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	
	public WebDriver driver;
	public static WebDriver sdriver;
	@BeforeSuite(alwaysRun = true)
	public void bsConfig() {
		
	}
	
//	@BeforeClass(alwaysRun = true)
//	@Parameters("browser")
//	@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig(/*String BROWSER*/) throws Exception {
		
		String BROWSER = fUtil.readDataFromPropertyFile("browser");
		
		String URL = fUtil.readDataFromPropertyFile("url");
		
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			
			driver = new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		
		wUtil.maximizeWindow(driver);
		sdriver=driver;
		
		driver.get(URL);
		
		System.out.println("==============browser is launched=============");
	}
	
	
	@BeforeMethod(alwaysRun = true)
	public void btConfig() throws Exception {
		
		LoginPage lp = new LoginPage(driver);
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("===========Application has logged in===============");
	}
	
	@AfterMethod(alwaysRun = true)
	public void atConfig() {
		DashboardPage dp  = new DashboardPage(driver);
		dp.logout(driver);
		System.out.println("===========Application has logged out===============");
	}
	
	
	
//	@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig() {
		driver.quit();
		
		System.out.println("=================driver is closed===============");
	}
	
	
	@AfterSuite(alwaysRun = true)
	public void closeConfig() {
		
	}
	
	
	
}
