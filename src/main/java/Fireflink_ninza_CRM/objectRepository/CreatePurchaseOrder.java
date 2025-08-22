package Fireflink_ninza_CRM.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Fireflink_ninza_CRM.GenericUitility.WebDriverUtility;

public class CreatePurchaseOrder extends WebDriverUtility {
	
	@FindBy(xpath = "//input[@name='dueDate']")
	private WebElement dueDateTF;
	
	@FindBy(xpath = "//input[@name='subject']")
	private WebElement subjectTF;
	
	@FindBy(xpath = "//div[@class='form-group']/label[text()='Contact']/following-sibling::div/button")
	private WebElement contactBtn;
	
	@FindBy(id = "search-criteria")
	private WebElement contactDropDown;
	
	@FindBy(id = "search-input")
	private WebElement searchTF;
	
	@FindBy(xpath = "//label[text()='Billing Address']/following-sibling::textarea[@name='address']")
	private WebElement billingAddressTF;
	
	@FindBy(xpath = "//label[text()='Billing PO Box']/following-sibling::input[@name='poBox']")
	private WebElement billingPOBoxTF;
	
	@FindBy(xpath = "//label[text()='Billing City']/following-sibling::input[@name='city']")
	private WebElement billingCityTF;
	
	@FindBy(xpath = "//label[text()='Billing State']/following-sibling::input[@name='state']")
	private WebElement billingStateTF;
	
	@FindBy(xpath = "//label[text()='Billing Postal Code']/following-sibling::input[@name='postalCode']")
	private WebElement billingPostalCodeTF;
	
	@FindBy(xpath = "//label[text()='Billing Country']/following-sibling::input[@name='country']")
	private WebElement billingCountryTF;
	
	@FindBy(xpath = "//label[text()='Shipping Address']/following-sibling::textarea[@name='address']")
	private WebElement shippingAddressTF;
	
	@FindBy(xpath = "//label[text()='Shipping PO Box']/following-sibling::input[@name='poBox']")
	private WebElement shippingPOBoxTF;
	
	@FindBy(xpath = "//label[text()='City']/following-sibling::input[@name='city']")
	private WebElement shippingCityTF;
	
	@FindBy(xpath = "//label[text()='State']/following-sibling::input[@name='state']")
	private WebElement shippingStateTF;
	
	@FindBy(xpath = "//label[text()='Postal Code']/following-sibling::input[@name='postalCode']")
	private WebElement shippingPostalCodeTF;
	
	@FindBy(xpath = "//label[text()='Country']/following-sibling::input[@name='country']")
	private WebElement shippingCountryTF;
	
	@FindBy(xpath = "//button[text()='Add Product']")
	private WebElement addProductBtn;
	
	@FindBy(id = "search-criteria")
	private WebElement productDropDown;
	
	@FindBy(id = "search-input")
	private WebElement productSearchTF;
	
	@FindBy(xpath = "//button[text()='Create Purchase Order']")
	private WebElement createPurchaseOrderBtn;
	
	@FindBy(xpath = "//button[@class='select-btn']")
	private WebElement selectBtn;
	
	@FindBy(id = "next-btn")
	private WebElement nextPageBtn;
	
	public WebElement getNextPageBtn() {
		return nextPageBtn;
	}

	public WebElement getSearchTF() {
		return searchTF;
	}

	public WebElement getSelectBtn() {
		return selectBtn;
	}

	public WebElement getCreatePurchaseOrderBtn() {
		return createPurchaseOrderBtn;
	}

	public CreatePurchaseOrder(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getDueDateTF() {
		return dueDateTF;
	}

	public WebElement getSubjectTF() {
		return subjectTF;
	}

	public WebElement getContactBtn() {
		return contactBtn;
	}

	public WebElement getBillingAddressTF() {
		return billingAddressTF;
	}

	public WebElement getBillingPOBoxTF() {
		return billingPOBoxTF;
	}

	public WebElement getBillingCityTF() {
		return billingCityTF;
	}

	public WebElement getBillingStateTF() {
		return billingStateTF;
	}

	public WebElement getBillingPostalCodeTF() {
		return billingPostalCodeTF;
	}

	public WebElement getBillingCountryTF() {
		return billingCountryTF;
	}

	public WebElement getShippingAddressTF() {
		return shippingAddressTF;
	}

	public WebElement getShippingPOBoxTF() {
		return shippingPOBoxTF;
	}

	public WebElement getShippingCityTF() {
		return shippingCityTF;
	}

	public WebElement getShippingStateTF() {
		return shippingStateTF;
	}

	public WebElement getShippingPostalCodeTF() {
		return shippingPostalCodeTF;
	}

	public WebElement getShippingCountryTF() {
		return shippingCountryTF;
	}

	public WebElement getAddProductBtn() {
		return addProductBtn;
	}

	public WebElement getProductDropDown() {
		return productDropDown;
	}

	public WebElement getProductSearchTF() {
		return productSearchTF;
	}
	
	//BUSINESS LOGIC
	public void fillPurchaseDetails(WebDriver driver,WebDriverWait wait, String dueDate,String subject,String organization,String contactName) {
		dueDateTF.sendKeys(dueDate);
		subjectTF.sendKeys(subject);
		contactBtn.click();
		switchWindow(driver, "Select Contact");
		handleDropDown("Organization", contactDropDown);
		searchTF.sendKeys(organization);
		WebElement contactNameSelectBtn = driver.findElement(By.xpath("//button[contains(@onclick,'"+contactName+"')]"));
		waitTillVisibiltyOfElement(wait,contactNameSelectBtn );
		contactNameSelectBtn.click();
		
		switchWindow(driver, "Ninza CRM");
		
	}
	
	public void fillAddressDetails(WebDriver driver,String billingAddress,String billingPOBox,String billingCity,String billingState,String billingPostalCode,String billingCountry,String shippingAddress,String shippingPOBox,String shippingCity,String shippingState,String shippingPostalCode,String shippingCountry) {
		
		billingAddressTF.sendKeys(billingAddress);
		billingPOBoxTF.sendKeys(billingPOBox);
		billingCityTF.sendKeys(billingCity);
		billingStateTF.sendKeys(billingState);
		billingPostalCodeTF.sendKeys(billingPostalCode);
		billingCountryTF.sendKeys(billingCountry);
		
		shippingAddressTF.sendKeys(shippingAddress);
		shippingPOBoxTF.sendKeys(shippingPOBox);
		shippingCityTF.sendKeys(shippingCity);
		shippingStateTF.sendKeys(shippingState);
		shippingPostalCodeTF.sendKeys(shippingPostalCode);
		shippingCountryTF.sendKeys(shippingCountry);
		
	}
	
	public void addProductsAndCreatePurchaseOrder(WebDriver driver,String productName) throws Exception {
		
		addProductBtn.click();
		switchWindow(driver,"Select Product");
		handleDropDown("Product Name",productDropDown);
		Thread.sleep(1000);
		searchTF.sendKeys(productName);
		
		while(true) {
			try {
					driver.findElement(By.xpath("//td[text()='"+productName+"']/following-sibling::td/button")).click();
					break;
			} catch (Exception e) {
				nextPageBtn.click();
			}
		}
		
		switchWindow(driver,"Ninza CRM" );
		createPurchaseOrderBtn.click();
		
	}
	
	
}
