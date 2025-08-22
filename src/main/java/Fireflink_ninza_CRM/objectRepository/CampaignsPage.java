package Fireflink_ninza_CRM.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage {

	@FindBy(xpath = "//b[contains(.,'Campaigns')]")
	private WebElement campaign;

	@FindBy(xpath = "//select[@class='form-control']")
	private WebElement campaignDropdown;

	@FindBy(xpath = "//input[@class='form-control']")
	private WebElement searchInput;

	@FindBy(xpath = "//span[contains(.,'Create')]")
	private WebElement createCampaignBtn;

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

	
	//Constructor and initialization
	
	public CampaignsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	
	//Getter to access identified Web Element

	public WebElement getCampaign() {
		return campaign;
	}

	public WebElement getCampaignDropdown() {
		return campaignDropdown;
	}

	public WebElement getSearchInput() {
		return searchInput;
	}

	public WebElement getCreateCampaignBtn() {
		return createCampaignBtn;
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

}
