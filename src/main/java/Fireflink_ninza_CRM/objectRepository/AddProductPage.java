package Fireflink_ninza_CRM.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Fireflink_ninza_CRM.GenericUitility.WebDriverUtility;

public class AddProductPage extends WebDriverUtility {

	@FindBy(xpath = "//input[@name='quantity']")
	private WebElement quantityTF;
	
	@FindBy(xpath = "//input[@name='productName']")
	private WebElement productNameTF;
	
	@FindBy(xpath = "//input[@name='price']")
	private WebElement pricePerUnitTF;
	
	@FindBy(xpath = "//select[@name='productCategory']")
	private WebElement categoryDropDown;
	
	@FindBy(xpath = "//select[@name='vendorId']")
	private WebElement vendorDropDown;
	
	@FindBy(xpath = "//button[text()='Add']")
	private WebElement addBtn;
	
	public AddProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getQuantityTF() {
		return quantityTF;
	}

	public WebElement getProductNameTF() {
		return productNameTF;
	}

	public WebElement getPricePerUnitTF() {
		return pricePerUnitTF;
	}

	public WebElement getCategoryDropDown() {
		return categoryDropDown;
	}

	public WebElement getVendorDropDown() {
		return vendorDropDown;
	}

	public WebElement getAddBtn() {
		return addBtn;
	}
	
	//BUSINESS LOGIC
	public void addProduct(String quantity,String productName,String pricePerUnit,String category,String vendor) {
		quantityTF.sendKeys(quantity);
		productNameTF.sendKeys(productName);

		pricePerUnitTF.clear();
		pricePerUnitTF.sendKeys(pricePerUnit);
		
		handleDropDown(categoryDropDown, category);
		handleDropDown(vendor, vendorDropDown);
		
		
		addBtn.click();
	}
	
	
	
}
