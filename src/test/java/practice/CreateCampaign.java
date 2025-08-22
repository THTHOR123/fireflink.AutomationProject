package practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Fireflink_ninza_CRM.GenericUitility.FileUtility;
import Fireflink_ninza_CRM.GenericUitility.WebDriverUtility;
import Fireflink_ninza_CRM.objectRepository.CampaignsPage;
import Fireflink_ninza_CRM.objectRepository.CreateCampaignsPage;
import Fireflink_ninza_CRM.objectRepository.DashboardPage;
import Fireflink_ninza_CRM.objectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaign {

	@Test
	public void createCampaignTest() throws Exception {
		
		FileUtility fileUtil = new FileUtility();
		WebDriverUtility webUtility = new WebDriverUtility();
		
		String BROWSER = fileUtil.readDataFromPropertyFile("browser");
		String URL = fileUtil.readDataFromPropertyFile("url");
		String USERNAME = fileUtil.readDataFromPropertyFile("username");
		String PASSWORD = fileUtil.readDataFromPropertyFile("password");
		
		//CAMPAIGN
		String CAMPAIGNNAME = fileUtil.readDataFromFile("Campaign", 1, 2);
		String TARGETSIZE = fileUtil.readDataFromFile("Campaign", 1, 3);
		
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
		CampaignsPage cp = new CampaignsPage(driver);
		CreateCampaignsPage ccp = new CreateCampaignsPage(driver);
		
		lp.loginToApp(USERNAME, PASSWORD);
		
		dp.getCampaignsLink().click();
		cp.getCreateCampaignBtn().click();
		
		ccp.createCampaign(CAMPAIGNNAME, TARGETSIZE);
		
		Thread.sleep(7000);
		
		dp.closeApplication(driver);
		
		
		
		
		
	}
}
