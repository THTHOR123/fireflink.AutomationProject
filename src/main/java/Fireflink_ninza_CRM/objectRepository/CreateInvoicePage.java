package Fireflink_ninza_CRM.objectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateInvoicePage {

	@FindBy(xpath = "//label[text()='Contact']/following-sibling::div/button")
	private WebElement contactBtn;
	
	@FindBy(id = "search-criteria")
	private WebElement contactDropDown;
	
	@FindBy(id = "search-input")
	private WebElement searchContactTF;
	
	@FindBy(xpath = "//input[@name='subject']")
	private WebElement subjectTF;
	
	@FindBy(xpath = "//label[text()='Sales Order']/following-sibling::div/button")
	private WebElement salesOrderBtn;
	
	@FindBy(id = "search-criteria")
	private WebElement salesOrderDropDown;
	
	@FindBy(id = "search-input")
	private WebElement searchSalesOrderTF;
	
	@FindBy(id = "next-btn")
	private WebElement nextPageBtn;
	
	@FindBy(xpath = "//input[@name='validTill']")
	private WebElement validTillDateTF;
	
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
	
	@FindBy(xpath = "//label[text()='Shipping City']/following-sibling::input[@name='city']")
	private WebElement shippingCityTF;
	
	@FindBy(xpath = "//label[text()='Shipping State']/following-sibling::input[@name='state']")
	private WebElement shippingStateTF;
	
	@FindBy(xpath = "//label[text()='Shipping Postal Code']/following-sibling::input[@name='postalCode']")
	private WebElement shippingPostalCodeTF;
	
	@FindBy(xpath = "//label[text()='Shipping Country']/following-sibling::input[@name='country']")
	private WebElement shippingCountry;
	
	@FindBy(xpath = "//button[text()='Add Product']")
	private WebElement addProductBtn;
	
	@FindBy(id = "search-criteria")
	private WebElement productDropDown;
	
	@FindBy(id = "search-input")
	private WebElement productSearchTF;
	
	@FindBy(xpath = "//button[text()='Create Invoice']")
	private WebElement createInvoiceBtn;
	
	public CreateInvoicePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactBtn() {
		return contactBtn;
	}

	public WebElement getContactDropDown() {
		return contactDropDown;
	}

	public WebElement getSearchContactTF() {
		return searchContactTF;
	}

	public WebElement getSubjectTF() {
		return subjectTF;
	}

	public WebElement getSalesOrderBtn() {
		return salesOrderBtn;
	}

	public WebElement getSalesOrderDropDown() {
		return salesOrderDropDown;
	}

	public WebElement getSearchSalesOrderTF() {
		return searchSalesOrderTF;
	}

	public WebElement getNextPageBtn() {
		return nextPageBtn;
	}

	public WebElement getValidTillDateTF() {
		return validTillDateTF;
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

	public WebElement getShippingCountry() {
		return shippingCountry;
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

	public WebElement getCreateInvoiceBtn() {
		return createInvoiceBtn;
	}
	
	
}
