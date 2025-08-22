package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

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

public class VerifySalesOrderWithUpdatedQuoteSubject {

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
		Row row = sheet.getRow(22);
		
		String quoteSubject = row.getCell(2).toString();
		
		
		
		
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
		
		driver.findElement(By.xpath("//a[text()='Quotes']")).click();
		
		WebElement quoteSelectElement = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select quoteDropDown = new Select(quoteSelectElement);
		
		quoteDropDown.selectByVisibleText("Search by Subject");
		
		driver.findElement(By.xpath("//input[@placeholder='Search by Subject']")).sendKeys(quoteSubject);
		
		driver.findElement(By.xpath("//td[text()='"+quoteSubject+ "']/following-sibling::td/a[@class='edit']")).click();
		
		WebElement quoteInput = driver.findElement(By.xpath("//input[@name='subject']"));
		quoteInput.clear();
		quoteInput.sendKeys(quoteSubject);
		
		driver.findElement(By.xpath("//button[text()='Update Quote']")).click();
		Thread.sleep(7000);
		
		driver.findElement(By.xpath("//a[text()='Sales Order']")).click();
		
		WebElement salesSelectElement = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select salesDropDown = new Select(salesSelectElement);
		salesDropDown.selectByVisibleText("Search by Subject");
		
		driver.findElement(By.xpath("//input[@placeholder='Search by Subject']")).sendKeys(quoteSubject);
		
		driver.findElement(By.xpath("//td[text()='"+quoteSubject+"']/following-sibling::td/a[@class='edit']")).click();
		
		String quoteSubjectInput = driver.findElement(By.xpath("//label[text()='Quote']/following-sibling::div/input")).getAttribute("value");
		
		if(quoteSubjectInput.equals(quoteSubject)) {
			System.out.println("Quote subject is updated");
		}
		else {
			System.out.println("quote subject is not updated");
		}
		
		WebElement profileIcon = driver.findElement(By.xpath("//div[@class='user-icon']"));
		act.moveToElement(profileIcon).perform();
		
		WebElement logout = driver.findElement(By.xpath("//div[@class='dropdown-item logout']"));
		act.moveToElement(logout).click().perform();
		
		driver.quit();
		
		
	}

}
