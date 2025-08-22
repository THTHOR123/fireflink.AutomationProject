package Fireflink_ninza_CRM.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLeadPage {

	@FindBy(name = "leadStatus")
	private WebElement leadStatusInput;

	@FindBy(name = "name")
	private WebElement leadNameInput;

	@FindBy(name = "rating")
	private WebElement ratingInput;

	@FindBy(name = "company")
	private WebElement companyInput;

	@FindBy(name = "assignedTo")
	private WebElement assignedToInput;

	@FindBy(name = "leadSource")
	private WebElement leadSourceInput;

	@FindBy(name = "industry")
	private WebElement industryInput;

	@FindBy(name = "annualRevenue")
	private WebElement annualRevenueInput;

	@FindBy(name = "address")
	private WebElement addressInput;

	@FindBy(name = "city")
	private WebElement cityInput;

	@FindBy(name = "noOfEmployees")
	private WebElement noOfEmployeesInput;

	@FindBy(name = "country")
	private WebElement countryInput;

	@FindBy(name = "postalCode")
	private WebElement postalCodeInput;

	@FindBy(name = "phone")
	private WebElement phoneInput;

	@FindBy(name = "website")
	private WebElement websiteInput;

	@FindBy(name = "email")
	private WebElement emailInput;

	@FindBy(name = "secondaryEmail")
	private WebElement secondaryEmailInput;

	@FindBy(name = "description")
	private WebElement descriptionInput;

	@FindBy(name = "//label[contains(.,'Campaign')]//following-sibling::div//button")
	private WebElement selectCampaignBtn;

	public CreateLeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
