package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatePurchaseOrderWithProductAndContact {

	@Test
	public  void sampleTest() throws Exception {
		
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
		
		
		
//		WebDriver driver = null;
//		
//		
//		if(browser.equals("chrome")) {
//			driver = new ChromeDriver();
//		}
//		else if(browser.equals("edge")) {
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//		}
//		else if(browser.equals("firefox")) {
//			driver = new FirefoxDriver();
//		}
//		else {
//			driver = new ChromeDriver();
//		}
//		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		String seleniumHubUrl = "https://cloud.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=ed7d6b81-8d50-4817-9fe9-7feaea784205&licenseId=LIC1026556&projectName=Practice+Session/";
		EdgeOptions browserOptions = new EdgeOptions();
		
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.password_manager_enabled", false);   // Disable password manager
		prefs.put("credentials_enable_service", false);         // Disable save password popup
		prefs.put("autofill.profile_enabled", false);           // Disable save address popup
		prefs.put("autofill.address_enabled", false);           // Extra safety

		browserOptions.setExperimentalOption("prefs", prefs);
		
		
		browserOptions.setPlatformName("Windows 11");
		browserOptions.setBrowserVersion("142");
		WebDriver driver = new RemoteWebDriver(new URL(seleniumHubUrl), browserOptions);
		driver.manage().window().setSize(new Dimension(1024, 768));


		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Actions act = new Actions(driver);
		
		driver.get(url);
		
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		
		driver.quit();
	}

}
