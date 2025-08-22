package Fireflink_ninza_CRM.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	@FindBy(xpath = "//span[.='Add Product']") private WebElement addProductBtn;
	@FindBy(xpath = "//select[@class=\"form-control\"]") private WebElement searchproductTypeInput;
	@FindBy(xpath = "//div[@class=\"col-sm-6\"]/input") private WebElement searchProductInput;
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public WebElement getAddProductBtn() {
		return addProductBtn;
	}
	public WebElement getSearchTypeInput() {
		return searchproductTypeInput;
	}
	public WebElement getSearchInput() {
		return searchProductInput;
	}
}
