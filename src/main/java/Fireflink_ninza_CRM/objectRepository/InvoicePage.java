package Fireflink_ninza_CRM.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoicePage {

	@FindBy(xpath = "//span[text()='Create Invoice']/ancestor::button")
	private WebElement createInvoiceBtn;
	
	@FindBy(xpath = "//select[@class='form-control']")
	private WebElement invoiceDropDown;
	
	
	@FindBy(xpath = "//input[@placeholder='Search by Invoice Id']")
	private WebElement inputByIdTF;
	
	@FindBy(xpath = "//input[@placeholder='Search by Subject']")
	private WebElement inputBySubjectTF;
	
	
	public InvoicePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getCreateInvoiceBtn() {
		return createInvoiceBtn;
	}


	public WebElement getInvoiceDropDown() {
		return invoiceDropDown;
	}


	public WebElement getInputByIdTF() {
		return inputByIdTF;
	}


	public WebElement getInputBySubjectTF() {
		return inputBySubjectTF;
	}
	
	
	
}
