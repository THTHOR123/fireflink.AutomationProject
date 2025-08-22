package Fireflink_ninza_CRM.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	// Rule 2 : Identify webElements using @FindBy, @FindAll, @FindBys

	// @FindBy : Identify single/multiple element using single locator

	@FindBy(id = "username")
	private WebElement userNameTF;

	@FindBy(id = "inputPassword")
	private WebElement passwordTF;

	@FindBy(xpath = "//button[contains(.,'Sign')]")
	private WebElement signInBtn;

	// Rule 3 : Create a constructor and initialize

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Rule 4 : Create getter method to access the Web Element created

	public WebElement getUserNameTF() {
		return userNameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getSignInBtn() {
		return signInBtn;
	}
	
	//business logic
	
	/**
	 * This method will perform login operation
	 * @param username
	 * @param password
	 */
	public void loginToApp(String username,String password) {
		userNameTF.sendKeys(username);
		passwordTF.sendKeys(password);
		signInBtn.click();
	}

}
