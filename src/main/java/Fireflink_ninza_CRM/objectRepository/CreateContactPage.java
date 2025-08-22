package Fireflink_ninza_CRM.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Fireflink_ninza_CRM.GenericUitility.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility{

	@FindBy(xpath = "//input[@name='contactName']")
	private WebElement contactNameTF;
	
	@FindBy(xpath = "//input[@name='organizationName']")
	private WebElement organizationTF;
	
	@FindBy(xpath = "//input[@name='mobile']")
	private WebElement mobileTF;
	
	@FindBy(xpath = "//input[@name='title']")
	private WebElement titleTF;
	
	@FindBy(xpath = "//DIV[contains(@class,'form-container')]/DIV/DIV/DIV/BUTTON")
	private WebElement campaignBtn;
	
	@FindBy(xpath = "//button[@class='select-btn']")
	private WebElement selectBtn;
	
	@FindBy(xpath = "//button[text()='Create Contact']")
	private WebElement createContactBtn;
	
	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public WebElement getContactNameTF() {
		return contactNameTF;
	}



	public WebElement getOrganizationTF() {
		return organizationTF;
	}



	public WebElement getMobileTF() {
		return mobileTF;
	}



	public WebElement getTitleTF() {
		return titleTF;
	}



	public WebElement getCampaignBtn() {
		return campaignBtn;
	}



	public WebElement getSelectBtn() {
		return selectBtn;
	}



	public WebElement getCreateContactBtn() {
		return createContactBtn;
	}



	//BUSINESS LOGIC
	public void createContact(WebDriver driver,String contactName,String organization,String mobile,String title) {
		contactNameTF.sendKeys(contactName);
		organizationTF.sendKeys(organization);
		mobileTF.sendKeys(mobile);
		titleTF.sendKeys(title);
		campaignBtn.click();
		switchWindow(driver, "Select Campaign");
		waitTillVisibiltyOfElement(driver, selectBtn);
//		selectBtn.click();
		
		try {
			selectBtn.click();
		} catch (Exception e) {
			// TODO: handle exception
			switchWindow(driver, "Ninza CRM");
		}
		switchWindow(driver, "Ninza CRM");
		createContactBtn.click();
		
	}
	
}
