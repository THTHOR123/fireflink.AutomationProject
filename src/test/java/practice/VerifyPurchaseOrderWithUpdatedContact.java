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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyPurchaseOrderWithUpdatedContact {

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
		Row row = sheet.getRow(13);
		
		//purchase order details
		String purchaseDueDate = row.getCell(2).toString();
		String purchaseSubject = row.getCell(3).toString();
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
		String contactId = row.getCell(16).toString();
		String contactName = row.getCell(17).toString();
		String organization = row.getCell(18).toString();
		String productName = row.getCell(19).toString();
		String updatedName = row.getCell(20).toString();
		
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
		
		
		driver.findElement(By.xpath("//a[text()='Purchase Order']")).click();
		
		driver.findElement(By.xpath("//span[text()='Create Order']/ancestor::button")).click();
		
		driver.findElement(By.xpath("//input[@name='dueDate']")).sendKeys(purchaseDueDate);
		
		driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(purchaseSubject);
		
		driver.findElement(By.xpath("//div[@class='form-group']/label[text()='Contact']/following-sibling::div/button")).click();
		
		String mainId = driver.getWindowHandle();
		Set<String> winId = driver.getWindowHandles();
			
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
		
		driver.findElement(By.xpath("//button[contains(@onclick,'"+contactName+"')]")).click();
		
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
		
		driver.findElement(By.id("search-input")).sendKeys(productName);
		
		driver.findElement(By.xpath("//button")).click();
		
		driver.switchTo().window(mainId);
		
		driver.findElement(By.xpath("//button[text()='Create Purchase Order']")).click();
		
		
		Thread.sleep(7000);
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Search by Contact Id']")).sendKeys(contactId);
		
		driver.findElement(By.xpath("//td[text()='"+contactId+"']/following-sibling::td/a[@class='edit']")).click();
		
		WebElement updateNameElement = driver.findElement(By.xpath("//input[@name='contactName']"));
		
		
		updateNameElement.clear();
		updateNameElement.sendKeys(updatedName);
		
		driver.findElement(By.xpath("//button[text()='Update Contact']")).click();
		
		
		driver.findElement(By.xpath("//a[text()='Purchase Order']")).click();
		
		WebElement orderSelect = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select orderDropDown = new Select(orderSelect);
		orderDropDown.selectByValue("subject");
		
		driver.findElement(By.xpath("//input[@placeholder='Search by Subject']")).sendKeys(purchaseSubject);
		
		driver.findElement(By.xpath("//td[text()='"+purchaseSubject+"']/following-sibling::td/a[@class='edit']")).click();
		
		String checkName = driver.findElement(By.xpath("//label[text()='Contact']/following-sibling::div/input")).getAttribute("value");
		
		if(checkName.equals(updatedName)){
			System.out.println("name is Updated");
		}
		else {
			System.out.println("Name is Not updated");
		}
		
//		driver.quit();)
		driver.quit();
		
	}
}
