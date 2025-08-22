package practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Fireflink_ninza_CRM.GenericUitility.FileUtility;
import Fireflink_ninza_CRM.GenericUitility.WebDriverUtility;
import Fireflink_ninza_CRM.objectRepository.AddProductPage;
import Fireflink_ninza_CRM.objectRepository.ContactsPage;
import Fireflink_ninza_CRM.objectRepository.CreateContactPage;
import Fireflink_ninza_CRM.objectRepository.CreatePurchaseOrder;
import Fireflink_ninza_CRM.objectRepository.DashboardPage;
import Fireflink_ninza_CRM.objectRepository.LoginPage;
import Fireflink_ninza_CRM.objectRepository.ProductPage;
import Fireflink_ninza_CRM.objectRepository.PurchaseOrder;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatePurchaseOrderWithProduct {

	public static void main(String[] args) throws Exception {
		
		FileUtility fileUtil = new FileUtility();
		WebDriverUtility webUtility = new WebDriverUtility();
		
		String BROWSER = fileUtil.readDataFromPropertyFile("browser");
		String URL = fileUtil.readDataFromPropertyFile("url");
		String USERNAME = fileUtil.readDataFromPropertyFile("username");
		String PASSWORD = fileUtil.readDataFromPropertyFile("password");
		
		//contact details
		
		String CONTACTNAME = fileUtil.readDataFromFile("Contacts", 7, 2);
		String ORGANIZATION = fileUtil.readDataFromFile("Contacts", 7, 3);
		String MOBILE = fileUtil.readDataFromFile("Contacts", 7, 4);
		String TITLE = fileUtil.readDataFromFile("Contacts", 7, 5);
		String CAMPAIGN = fileUtil.readDataFromFile("Contacts", 7, 6);
		
		//product details
		String PRODUCTNAME = fileUtil.readDataFromFile("Contacts", 7, 7);
		String QUANTITY =fileUtil.readDataFromFile("Contacts", 7, 8);
		String PRICE = fileUtil.readDataFromFile("Contacts", 7, 9);
		String CATEGORY = fileUtil.readDataFromFile("Contacts", 7, 10);
		String VENDOR = fileUtil.readDataFromFile("Contacts", 7, 11);
		
		//purchase order details
		String PURCHASEDUEDATE = fileUtil.readDataFromFile("Contacts", 7, 12);
		String PURCHASESUBJECT = fileUtil.readDataFromFile("Contacts", 7, 13);
		String BILLINGADDRESS = fileUtil.readDataFromFile("Contacts", 7, 14);
		String BILLINGPOBOX = fileUtil.readDataFromFile("Contacts", 7, 15);
		String BILLINGCITY = fileUtil.readDataFromFile("Contacts", 7, 16);
		String BILLINGSTATE =fileUtil.readDataFromFile("Contacts", 7, 17);
		String BILLINGPOSTALCODE = fileUtil.readDataFromFile("Contacts", 7, 18);
		String BILLINGCOUNTRY = fileUtil.readDataFromFile("Contacts", 7, 19);
		String SHIPPINGADDRESS = fileUtil.readDataFromFile("Contacts", 7, 20);
		String SHIPPINGPOBOX = fileUtil.readDataFromFile("Contacts", 7, 21);
		String SHIPPINGCITY = fileUtil.readDataFromFile("Contacts", 7, 22);
		String SHIPPINGSTATE = fileUtil.readDataFromFile("Contacts", 7, 23);
		String SHIPPINGPOSTALCODE = fileUtil.readDataFromFile("Contacts", 7, 24);
		String SHIPPINGCOUNTRY = fileUtil.readDataFromFile("Contacts", 7, 25);
		
		WebDriver driver = null;
		
		
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(BROWSER.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		
		webUtility.maximizeWindow(driver);
		webUtility.implicitlyWait(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get(URL);
		
		LoginPage lp = new LoginPage(driver);
		DashboardPage dp = new DashboardPage(driver);
		ContactsPage cp = new ContactsPage(driver);
		CreateContactPage ccp = new CreateContactPage(driver);
		ProductPage pp = new ProductPage(driver);
		AddProductPage app = new AddProductPage(driver);
		PurchaseOrder po = new PurchaseOrder(driver);
		CreatePurchaseOrder cpo = new CreatePurchaseOrder(driver);
		
		lp.loginToApp(USERNAME, PASSWORD);
		
		
		dp.getContactsLink().click();
		
		cp.getCreateContactBtn().click();
		
		//CREATE CONTACT 
		
		ccp.createContact(driver, CONTACTNAME, ORGANIZATION, MOBILE, TITLE);
		
//		"//button[text()='Create Contact']")).click();
		
		Thread.sleep(7000);
		//product
		dp.getProductsLink().click();
		
		pp.getAddProductBtn().click();
		
		app.addProduct(QUANTITY, PRODUCTNAME, PRICE, CATEGORY, VENDOR);
//		
		Thread.sleep(7000);
		
		//CREATE PURCHASE ORDER
		dp.getPurchaseOrderLink().click();
		po.getCreatePurchaseOrderBtn().click();
		
		cpo.fillPurchaseDetails(driver, wait, PURCHASEDUEDATE, PURCHASESUBJECT, ORGANIZATION, CONTACTNAME);
		cpo.fillAddressDetails(driver, BILLINGADDRESS, BILLINGPOBOX, BILLINGCITY, BILLINGSTATE, BILLINGPOSTALCODE, BILLINGCOUNTRY, SHIPPINGADDRESS, SHIPPINGPOBOX, SHIPPINGCITY, SHIPPINGSTATE, SHIPPINGPOSTALCODE, SHIPPINGCOUNTRY);
		cpo.addProductsAndCreatePurchaseOrder(driver, PRODUCTNAME);
		
		Thread.sleep(7000);
		
		driver.quit();
		
	}
}
