package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateInvoiceWithMandatoryFields {

	public static void main(String[] args) throws Exception {
		
		FileInputStream fis = new FileInputStream("src/test/resources/CommonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		
		String browser = pObj.getProperty("browser");
		String url = pObj.getProperty("url");
		String username = pObj.getProperty("username");
		String password = pObj.getProperty("password");
		
		FileInputStream xlfis = new FileInputStream("src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(xlfis);
		Sheet sheet = wb.getSheet("Contacts");
		Row row = sheet.getRow(28);
		
		//contact Details
		String contactName = row.getCell(2).toString();
		String organization = row.getCell(3).toString();
		String mobile = row.getCell(4).toString();
		String title = row.getCell(5).toString();
		String campaignId = row.getCell(6).toString();
		
		String Quantity = row.getCell(7).toString();
		String price = row.getCell(8).toString();
		String category = row.getCell(9).toString();
		String vendor = row.getCell(10).toString();
		String invoiceSubject = row.getCell(11).toString();
		
		row = sheet.getRow(31);
		String salesSubject = row.getCell(2).toString();
		String validTillDate = row.getCell(3).toString();
		String billingAddress = row.getCell(4).toString();
		String billingPOBox = row.getCell(5).toString();
		String billingCity = row.getCell(6).toString();
		String billingState =row.getCell(7).toString();
		String billingPostalCode = row.getCell(8).toString();
		String billingCountry = row.getCell(9).toString();
		String shippingAddress = row.getCell(10).toString();
		String shippingPOBox = row.getCell(11).toString();
		String shippingCity =row.getCell(12).toString();
		String shippingState = row.getCell(13).toString();
		String shippingPostalCode = row.getCell(14).toString();
		String shippingCountry = row.getCell(15).toString();
		String productName = row.getCell(16).toString();
		
		
		
		
		
		
		
		
		WebDriver driver = null;
		
		
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Actions act = new Actions(driver);
		
		driver.get(url);
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("inputPassword")).sendKeys(password);
		
		driver.findElement(By.tagName("button")).click();
		
driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		driver.findElement(By.xpath("//span[text()='Create Contact']/ancestor::button")).click();
		
		//CREATE CONTACT 
		driver.findElement(By.xpath("//input[@name='contactName']")).sendKeys(contactName);
		
		driver.findElement(By.xpath("//input[@name='organizationName']")).sendKeys(organization);
		
		driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys(mobile);
		
		driver.findElement(By.xpath("//input[@name='title']")).sendKeys(title);
		
		
		driver.findElement(By.xpath("//DIV[contains(@class,'form-container')]/DIV/DIV/DIV/BUTTON")).click();
		
		
		
		String mainId = driver.getWindowHandle();
		Set<String> winId = driver.getWindowHandles();
		
		for(String id:winId) {
			if(!id.equals(mainId))
			{
				driver.switchTo().window(id);
			}
		}
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("search-input")).sendKeys(campaignId);
		
		WebElement selectButton = driver.findElement(By.xpath("//button[@class='select-btn']"));
		wait.until(ExpectedConditions.visibilityOf(selectButton)).click();
		
		
		driver.switchTo().window(mainId);
		
		driver.findElement(By.xpath("//button[text()='Create Contact']")).click();
		
		Thread.sleep(7000);
		
		driver.findElement(By.xpath("//a[text()='Sales Order']")).click();
		
		driver.findElement(By.xpath("//span[text()='Create Order']/ancestor::button")).click();
		
		driver.findElement(By.xpath("//label[text()='Opportunity']/following-sibling::div/button")).click();
		
		winId = driver.getWindowHandles();
		
		for(String id:winId) {
			if(!id.equals(mainId))
			{
				driver.switchTo().window(id);
			}
		}
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@class='select-btn']")))).click();
		
		driver.switchTo().window(mainId);
		
		driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(salesSubject);
		
		driver.findElement(By.xpath("//label[text()='Quote']/following-sibling::div/button")).click();
		
		winId = driver.getWindowHandles();
		
		for(String id:winId) {
			if(!id.equals(mainId))
			{
				driver.switchTo().window(id);
			}
		}
		
		
		WebElement quoteSelectElement = driver.findElement(By.id("search-field"));
		Select quoteDropDown = new Select(quoteSelectElement);
		quoteDropDown.selectByVisibleText("Subject");
		Thread.sleep(2000);
		driver.findElement(By.id("search-input")).sendKeys(salesSubject);
		
		driver.findElement(By.xpath("//button[contains(@onclick,'"+salesSubject+"')]")).click();
		
		driver.switchTo().window(mainId);
		
		driver.findElement(By.xpath("//input[@name='validTill']")).sendKeys(validTillDate);
		
		driver.findElement(By.xpath("//label[text()='Contact']/following-sibling::div/button")).click();
		
		 winId = driver.getWindowHandles();
			
			for(String id:winId) {
				if(!id.equals(mainId))
				{
					driver.switchTo().window(id);
				}
			}
			
		 WebElement contactSelect = driver.findElement(By.id("search-criteria"));
		Select contactdroppdown = new Select(contactSelect);
		contactdroppdown.selectByVisibleText("Organization");
		
			
		
		driver.findElement(By.id("search-input")).sendKeys(organization);
		
		driver.findElement(By.xpath("//button[contains(@onclick,'"+contactName+"')]")).click();
		
		driver.switchTo().window(mainId);
		
		
		driver.findElement(By.xpath("//label[text()='Billing Address']/following-sibling::textarea[@name='address']")).sendKeys(billingAddress);
		
		driver.findElement(By.xpath("//label[text()='Billing PO Box']/following-sibling::input[@name='poBox']")).sendKeys(billingPOBox);
		
		driver.findElement(By.xpath("//label[text()='Billing City']/following-sibling::input[@name='city']")).sendKeys(billingCity);
		
		driver.findElement(By.xpath("//label[text()='Billing State']/following-sibling::input[@name='state']")).sendKeys(billingState);
		
		driver.findElement(By.xpath("//label[text()='Billing Postal Code']/following-sibling::input[@name='postalCode']")).sendKeys(billingPostalCode);  
		
		driver.findElement(By.xpath("//label[text()='Billing Country']/following-sibling::input[@name='country']")).sendKeys(billingCountry);
		
		//shippping
		driver.findElement(By.xpath("//label[text()='Shipping Address']/following-sibling::textarea[@name='address']")).sendKeys(shippingAddress);
		
		driver.findElement(By.xpath("//label[text()='Shipping PO Box']/following-sibling::input[@name='poBox']")).sendKeys(shippingPOBox);
		
		driver.findElement(By.xpath("//label[text()='City']/following-sibling::input[@name='city']")).sendKeys(shippingCity);
		
		driver.findElement(By.xpath("//label[text()='State']/following-sibling::input[@name='state']")).sendKeys(shippingState);
		
		driver.findElement(By.xpath("//label[text()='Postal Code']/following-sibling::input[@name='postalCode']")).sendKeys(shippingPostalCode);  
		
		driver.findElement(By.xpath("//label[text()='Country']/following-sibling::input[@name='country']")).sendKeys(shippingCountry);
		
		
		driver.findElement(By.xpath("//button[text()='Add Product']")).click();
		
//		act.scrollByAmount(0, 200).perform();
		
		winId = driver.getWindowHandles();
		
		for(String id:winId) {
			if(!id.equals(mainId))
			{
				driver.switchTo().window(id);
			}
		}
		
		WebElement productSelect = driver.findElement(By.id("search-criteria"));
		
		Select productDropdown = new Select(productSelect);
		
		productDropdown.selectByVisibleText("Product Name");
		
		Thread.sleep(2000);
		
		
		driver.findElement(By.id("search-input")).sendKeys(productName);
		
		while(true) {
			try {
					driver.findElement(By.xpath("//td[text()='"+productName+"']/following-sibling::td/button")).click();
					break;
				
			} catch (Exception e) {
				// TODO: handle exception
				act.scrollByAmount(0, 200).perform();
				driver.findElement(By.id("next-btn")).click();
			}
			
		}

//	driver.switchTo().window(mainId);
		
//		driver.findElement(By.xpath("//button")).click();
		
		driver.switchTo().window(mainId);
		
		driver.findElement(By.xpath("//button[text()='Create Sales Order']")).click();
		
		Thread.sleep(7000);
		
		//create product
driver.findElement(By.xpath("//a[text()='Products']")).click();
		
		driver.findElement(By.xpath("//span[text()='Add Product']/ancestor::button")).click();
		
		driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys(Quantity);
		
		driver.findElement(By.xpath("//input[@name='productName']")).sendKeys(productName);
		
		WebElement priceUnit = driver.findElement(By.xpath("//input[@name='price']"));
		priceUnit.clear();
		priceUnit.sendKeys(price);
		
		WebElement categorySelect = driver.findElement(By.xpath("//select[@name='productCategory']"));
		
		Select categoryDropdown = new Select(categorySelect);
		
		categoryDropdown.selectByValue(category);
		
		WebElement vendorSelect = driver.findElement(By.xpath("//select[@name='vendorId']"));
		Select vendorDropdown = new Select(vendorSelect);
		vendorDropdown.selectByVisibleText(vendor);
		
		driver.findElement(By.xpath("//button[text()='Add']")).click();
		
		Thread.sleep(7000);
		
		//INVOICE
		
		driver.findElement(By.xpath("//a[text()='Invoice']")).click();
		
		driver.findElement(By.xpath("//span[text()='Create Invoice']/ancestor::button")).click();
		
		driver.findElement(By.xpath("//label[text()='Contact']/following-sibling::div/button")).click();
		
		 winId = driver.getWindowHandles();
			
			for(String id:winId) {
				if(!id.equals(mainId))
				{
					driver.switchTo().window(id);
				}
			}
			
		  contactSelect = driver.findElement(By.id("search-criteria"));
		 contactdroppdown = new Select(contactSelect);
		contactdroppdown.selectByVisibleText("Organization");
		
			
		
		driver.findElement(By.id("search-input")).sendKeys(organization);
		
		driver.findElement(By.xpath("//button[contains(@onclick,'"+contactName+"')]")).click();
		
		driver.switchTo().window(mainId);
		
		
		driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(invoiceSubject);
		
		driver.findElement(By.xpath("//label[text()='Sales Order']/following-sibling::div/button")).click();
		
		winId = driver.getWindowHandles();
		
		for(String id:winId) {
			if(!id.equals(mainId))
			{
				driver.switchTo().window(id);
			}
		}
		
	  WebElement salesSelect = driver.findElement(By.id("search-criteria"));
	 Select salesdroppdown = new Select(salesSelect);
	salesdroppdown.selectByVisibleText("Subject");
	
		Thread.sleep(2000);
	
	driver.findElement(By.id("search-input")).sendKeys(salesSubject);
	

	while(true) {
		try {
			driver.findElement(By.xpath("//button[contains(@onclick,'"+salesSubject+"')]")).click();
				break;
			
		} catch (Exception e) {
			// TODO: handle exception
			act.scrollByAmount(0, 200).perform();
			driver.findElement(By.id("next-btn")).click();
		}
		
	}

	driver.switchTo().window(mainId);
	
	
//	driver.findElement(By.xpath("//button[contains(@onclick,'"+salesSubject+"')]")).click();
	
	driver.findElement(By.xpath("//input[@name='validTill']")).sendKeys(validTillDate);
	
	
		
	driver.findElement(By.xpath("//label[text()='Billing Address']/following-sibling::textarea[@name='address']")).sendKeys(billingAddress);
	
	driver.findElement(By.xpath("//label[text()='Billing PO Box']/following-sibling::input[@name='poBox']")).sendKeys(billingPOBox);
	
	driver.findElement(By.xpath("//label[text()='Billing City']/following-sibling::input[@name='city']")).sendKeys(billingCity);
	
	driver.findElement(By.xpath("//label[text()='Billing State']/following-sibling::input[@name='state']")).sendKeys(billingState);
	
	driver.findElement(By.xpath("//label[text()='Billing Postal Code']/following-sibling::input[@name='postalCode']")).sendKeys(billingPostalCode);  
	
	driver.findElement(By.xpath("//label[text()='Billing Country']/following-sibling::input[@name='country']")).sendKeys(billingCountry);
	
	//shippping
	driver.findElement(By.xpath("//label[text()='Shipping Address']/following-sibling::textarea[@name='address']")).sendKeys(shippingAddress);
	
	driver.findElement(By.xpath("//label[text()='Shipping PO Box']/following-sibling::input[@name='poBox']")).sendKeys(shippingPOBox);
	
	driver.findElement(By.xpath("//label[text()='Shipping City']/following-sibling::input[@name='city']")).sendKeys(shippingCity);
	
	driver.findElement(By.xpath("//label[text()='Shipping State']/following-sibling::input[@name='state']")).sendKeys(shippingState);
	
	driver.findElement(By.xpath("//label[text()='Shipping Postal Code']/following-sibling::input[@name='postalCode']")).sendKeys(shippingPostalCode);  
	
	driver.findElement(By.xpath("//label[text()='Shipping Country']/following-sibling::input[@name='country']")).sendKeys(shippingCountry);
	
	
	driver.findElement(By.xpath("//button[text()='Add Product']")).click();
	
	
	winId = driver.getWindowHandles();
	
	for(String id:winId) {
		if(!id.equals(mainId))
		{
			driver.switchTo().window(id);
		}
	}
	driver.manage().window().maximize();
	
	 productSelect = driver.findElement(By.id("search-criteria"));
	
	 productDropdown = new Select(productSelect);
	
	productDropdown.selectByVisibleText("Product Name");
	
	Thread.sleep(2000);
	driver.findElement(By.id("search-input")).sendKeys(productName);
	
	
	
			while(true) {
				try {
						driver.findElement(By.xpath("//td[text()='"+productName+"']/following-sibling::td/button")).click();
						break;
					
				} catch (Exception e) {
					// TODO: handle exception
					act.scrollByAmount(0, 200).perform();
					driver.findElement(By.id("next-btn")).click();
				}
				
			}
	
		driver.switchTo().window(mainId);
		
		driver.findElement(By.xpath("//button[text()='Create Invoice']")).click();
	
		driver.quit();
		

	}
}
