package Fireflink_ninza_CRM.objectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateUserPage {

	@FindBy(name = "empName")
	private WebElement userFullNameTF;
	
	@FindBy(name = "username")
	private WebElement userNameTF;
	
	@FindBy(name = "mobileNo")
	private WebElement mobileTF;
	
	@FindBy(name = "password")
	private WebElement passwordTF;
	
	@FindBy(name = "email")
	private WebElement emailTF;
	
	public CreateUserPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserFullNameTF() {
		return userFullNameTF;
	}

	public WebElement getUserNameTF() {
		return userNameTF;
	}

	public WebElement getMobileTF() {
		return mobileTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getEmailTF() {
		return emailTF;
	}
	
	
}
