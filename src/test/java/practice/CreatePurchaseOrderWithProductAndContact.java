package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
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

public class CreatePurchaseOrderWithProductAndContact {

	public static void main(String[] args) throws Exception {
		
//		Random random = new Random();
		
		
		FileInputStream fis = new FileInputStream("src/test/resources/CommonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		
		String browser = pObj.getProperty("browser");
		String url = pObj.getProperty("url");
		String username = pObj.getProperty("username");
		String password = pObj.getProperty("password");
		
		
		FileInputStream xlfis = new FileInputStream("src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(xlfis);
		Sheet contactSheet = wb.getSheet("Contacts");
		
		Row contactRow = contactSheet.getRow(7);
		
		//contact details
		String contactName = contactRow.getCell(2).toString();
		String organization = contactRow.getCell(3).toString();
		String mobile = contactRow.getCell(4).toString();
		String title = contactRow.getCell(5).toString();
		String campaign = contactRow.getCell(6).toString();
		
		//product details
		String productName = contactRow.getCell(7).toString();
		String Quantity = contactRow.getCell(8).toString();
		String price = contactRow.getCell(9).toString();
		String category = contactRow.getCell(10).toString();
		String vendor = contactRow.getCell(11).toString();
		
		//purchase order details
		String purchaseDueDate = contactRow.getCell(12).toString();
		String purchaseSubject = contactRow.getCell(13).toString();
		String billingAddress = contactRow.getCell(14).toString();
		String billingPOBox = contactRow.getCell(15).toString();
		String billingCity = contactRow.getCell(16).toString();
		String billingState = contactRow.getCell(17).toString();
		String billingPostalCode = contactRow.getCell(18).toString();
		String billingCountry = contactRow.getCell(19).toString();
		String shippingAddress = contactRow.getCell(20).toString();
		String shippingPOBox = contactRow.getCell(21).toString();
		String shippingCity = contactRow.getCell(22).toString();
		String shippingState = contactRow.getCell(23).toString();
		String shippingPostalCode = contactRow.getCell(24).toString();
		String shippingCountry = contactRow.getCell(25).toString();
		
		
		
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
		
		WebElement selectButton = driver.findElement(By.xpath("//button[@class='select-btn']"));
		wait.until(ExpectedConditions.visibilityOf(selectButton)).click();
		
		
		driver.switchTo().window(mainId);
		
		driver.findElement(By.xpath("//button[text()='Create Contact']")).click();
		
		Thread.sleep(7000);
//		wait.until(ExpectedConditions.vis);
		
//		driver.findElement(By.xpath("//div[@class='Toastify']"));
		//CREATE PRODUCTS
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
		
		//CREATE PURCHASE ORDER
		driver.findElement(By.xpath("//a[text()='Purchase Order']")).click();
		
		driver.findElement(By.xpath("//span[text()='Create Order']/ancestor::button")).click();
		
		driver.findElement(By.xpath("//input[@name='dueDate']")).sendKeys(purchaseDueDate);
		
		driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(purchaseSubject);
		
		driver.findElement(By.xpath("//div[@class='form-group']/label[text()='Contact']/following-sibling::div/button")).click();
		
		winId = driver.getWindowHandles();
			
			for(String id:winId) {
				if(!id.equals(mainId))
				{
					driver.switchTo().window(id);
				}
			}
			
		
			WebElement contactSelect = driver.findElement(By.id("search-criteria"));
			Select contactdroppdown=  new Select(contactSelect);
			contactdroppdown.selectByVisibleText("Organization");
			
				
			
			driver.findElement(By.id("search-input")).sendKeys(organization);
			
//			driver.findElement(By.xpath("//button[contains(@onclick,'"+contactName+"')]")).click();
			
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[contains(@onclick,'"+contactName+"')]")))).click();
		
		driver.switchTo().window(mainId);
		
		act.scrollByAmount(0, 200).perform();
		
		//billing
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
		
		driver.findElement(By.xpath("//label[text()='State']/following-sibling::input[@name='state']")).sendKeys(billingState);
		
		driver.findElement(By.xpath("//label[text()='Postal Code']/following-sibling::input[@name='postalCode']")).sendKeys(shippingPostalCode);  
		
		driver.findElement(By.xpath("//label[text()='Country']/following-sibling::input[@name='country']")).sendKeys(shippingCountry);
		
		driver.findElement(By.xpath("//button[text()='Add Product']")).click();
		
		act.scrollByAmount(0, 200).perform();
		
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
		
		driver.findElement(By.id("search-input")).sendKeys(productName);
		
		driver.findElement(By.xpath("//button")).click();
		
		driver.switchTo().window(mainId);
		
		driver.findElement(By.xpath("//button[text()='Create Purchase Order']")).click();
		
		Thread.sleep(7000);
		
		WebElement userLogo = driver.findElement(By.xpath("//div[@class='user-icon']"));
		
//		act.moveToElement(userLogo).perform();
//		act.moveByOffset(-10, 50).click().perform();
		
		driver.quit();
	}

}
