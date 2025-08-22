package practice;

import java.io.FileInputStream;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyInvoiceWithUpdatedProduct {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
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
		
		row = sheet.getRow(34);
		
		String updatedPrice = row.getCell(2).toString();
		
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Actions act = new Actions(driver);
		
		driver.get(url);
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("inputPassword")).sendKeys(password);
		
		driver.findElement(By.tagName("button")).click();
		
		
		
		
		
		
		
		
		driver.findElement(By.xpath("//a[text()='Invoice']")).click();
		
		driver.findElement(By.xpath("//span[text()='Create Invoice']/ancestor::button")).click();
		
		driver.findElement(By.xpath("//label[text()='Contact']/following-sibling::div/button")).click();
		
		String mainId = driver.getWindowHandle();
		 Set<String> winId = driver.getWindowHandles();
			
			for(String id:winId) {
				if(!id.equals(mainId))
				{
					driver.switchTo().window(id);
				}
			}
			
		  WebElement contactSelect = driver.findElement(By.id("search-criteria"));
		 Select contactdroppdown = new Select(contactSelect);
		contactdroppdown.selectByVisibleText("Organization");
		
			Thread.sleep(2000);
		
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
	
		driver.switchTo().window(mainId);
		
		driver.findElement(By.xpath("//button[text()='Create Invoice']")).click();
		
		Thread.sleep(7000);
		
		
		
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		
		WebElement prodSelect = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select prodDropDown = new Select(prodSelect);
		prodDropDown.selectByValue("productName");
		
		driver.findElement(By.xpath("//input[@placeholder='Search by product Name']")).sendKeys(productName);
		
		driver.findElement(By.xpath("//td[text()='"+productName+"']/following-sibling::td/a[@class='edit']")).click();
		
		WebElement priceUpdate = driver.findElement(By.xpath("//input[@name='price']"));
		priceUpdate.clear();
		priceUpdate.sendKeys(updatedPrice);
		
		driver.findElement(By.xpath("//button[text()='Update']")).click();
		Thread.sleep(7000);
		
		driver.findElement(By.xpath("//a[text()='Invoice']")).click();
		
		WebElement invoiceSelectElement = driver.findElement(By.xpath("//select[@class='form-control']"));
		
		Select invoiceDropDown = new Select(invoiceSelectElement);
		invoiceDropDown.selectByVisibleText("Search by Subject");
		
		driver.findElement(By.xpath("//input[@placeholder='Search by Subject']")).sendKeys(invoiceSubject);
		
		driver.findElement(By.xpath("//td[text()='"+invoiceSubject+"']/following-sibling::td/a[@class='edit']")).click();
		
		
		String priceCheck = driver.findElement(By.xpath("//label[text()='Total Amount: ']/following-sibling::input")).getText();
		
		if(!priceCheck.substring(1).equals(priceUpdate)) {
			System.out.println("price not updated");
		}
		else {
			System.out.println("price updated");
		}
		driver.quit();
		
		
		

	}

}
