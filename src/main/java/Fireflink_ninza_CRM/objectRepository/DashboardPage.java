package Fireflink_ninza_CRM.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Fireflink_ninza_CRM.GenericUitility.WebDriverUtility;

public class DashboardPage extends WebDriverUtility{

	@FindBy(xpath = "//a[contains(.,'Campaigns')]")
	private WebElement campaignsLink;

	@FindBy(xpath = "//a[contains(.,'Contact')]")
	private WebElement contactsLink;

	@FindBy(xpath = "//a[contains(.,'Leads')]")
	private WebElement leadsLink;

	@FindBy(xpath = "//a[contains(.,'Opportunities')]")
	private WebElement opportunitiesLink;

	@FindBy(xpath = "//a[contains(.,'Products')]")
	private WebElement productsLink;

	@FindBy(xpath = "//a[contains(.,'Quotes')]")
	private WebElement quotesLink;

	@FindBy(xpath = "//a[contains(.,'Purchase')]")
	private WebElement purchaseOrderLink;

	@FindBy(xpath = "//a[contains(.,'Sales')]")
	private WebElement salesOrderLink;

	@FindBy(xpath = "//a[contains(.,'Invoice')]")
	private WebElement invoiceLink;

	@FindBy(xpath = "//li//li[contains(.,'Admin Console')]")
	private WebElement adminConsoleLink;

	@FindBy(xpath = "//div[@class='user-icon']")
	private WebElement profileBtn;

	@FindBy(xpath = "//div[@class='dropdown-item' and contains(.,'ADMIN')]")
	private WebElement adminBtn;

	@FindBy(xpath = "(//div[@class='dropdown-item'])[1]")
	private WebElement userBtn;

	@FindBy(xpath = "//div[@class='dropdown-item logout']")
	private WebElement logoutBtn;

	// Create the constructor and initialize
	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Rule 4 : Create getter method to access the Web Element created

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getLeadsLink() {
		return leadsLink;
	}

	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getQuotesLink() {
		return quotesLink;
	}

	public WebElement getPurchaseOrderLink() {
		return purchaseOrderLink;
	}

	public WebElement getSalesOrderLink() {
		return salesOrderLink;
	}

	public WebElement getInvoiceLink() {
		return invoiceLink;
	}

	public WebElement getAdminConsoleLink() {
		return adminConsoleLink;
	}

	public WebElement getProfileBtn() {
		return profileBtn;
	}

	public WebElement getAdminBtn() {
		return adminBtn;
	}

	public WebElement getUserBtn() {
		return userBtn;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
	
	//BUSINESS LOGIC
	
	public void logout(WebDriver driver) {
		
		mouseHoveringAction(driver, profileBtn);
//		mouseHoveringAction(driver, logoutBtn);
		logoutBtn.click();
	}
	
	public void closeApplication(WebDriver driver) {
		driver.quit();
	}

}
