package Fireflink_ninza_CRM.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	@FindBy(xpath = "//b[contains(.,'Contacts')]")
	private WebElement contacts;
	
	@FindBy(xpath = "//select[@class='form-control']")
	private WebElement contactDropdown;
	
	@FindBy(xpath = "//input[@class='form-control']")
	private WebElement searchInputTF;
	
	@FindBy(xpath = "//span[contains(.,'Create')]")
	private WebElement createContactBtn;
	
	@FindBy(xpath = "//i[@title='Edit']")
	private WebElement editBtn;

	@FindBy(xpath = "//i[@title='Delete']")
	private WebElement deleteBtn;

	@FindBy(xpath = "//a[@aria-label='Go to first page']")
	private WebElement firstPageBtn;

	@FindBy(xpath = "//a[@aria-label='Go to previous page']")
	private WebElement previousPageBtn;

	@FindBy(xpath = "//a[@aria-label='Go to last page']")
	private WebElement lastPageBtn;

	@FindBy(xpath = "//a[@aria-label='Go to next page']")
	private WebElement nextPageBtn;
	
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getContacts() {
		return contacts;
	}

	public WebElement getContactDropdown() {
		return contactDropdown;
	}

	public WebElement getSearchInputTF() {
		return searchInputTF;
	}

	public WebElement getCreateContactBtn() {
		return createContactBtn;
	}

	public WebElement getEditBtn() {
		return editBtn;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	public WebElement getFirstPageBtn() {
		return firstPageBtn;
	}

	public WebElement getPreviousPageBtn() {
		return previousPageBtn;
	}

	public WebElement getLastPageBtn() {
		return lastPageBtn;
	}

	public WebElement getNextPageBtn() {
		return nextPageBtn;
	}
	
	
	//BUSINESS LOGIC
	
	
}
