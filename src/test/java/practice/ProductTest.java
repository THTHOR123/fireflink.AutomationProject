package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Fireflink_ninza_CRM.GenericUitility.BaseClass;
import Fireflink_ninza_CRM.objectRepository.AddProductPage;
import Fireflink_ninza_CRM.objectRepository.DashboardPage;
import Fireflink_ninza_CRM.objectRepository.ProductPage;

@Listeners(Fireflink_ninza_CRM.GenericUitility.ListnerImpl.class)
public class ProductTest extends BaseClass{

	@Test
	public void tc_002_CreateProductTest() throws Exception, IOException {
		
		String PRODUCTNAME = fUtil.readDataFromFile("Contacts", 7, 7);
		String QUANTITY =fUtil.readDataFromFile("Contacts", 7, 8);
		String PRICE = fUtil.readDataFromFile("Contacts", 7, 9);
		String CATEGORY = fUtil.readDataFromFile("Contacts", 7, 10);
		String VENDOR = fUtil.readDataFromFile("Contacts", 7, 11);
		
		DashboardPage dp = new DashboardPage(driver);
		ProductPage pp = new ProductPage(driver);
		AddProductPage app = new AddProductPage(driver);
		
		dp.getProductsLink().click();
		
		pp.getAddProductBtn().click();
		
		app.addProduct(QUANTITY, PRODUCTNAME, PRICE, CATEGORY, VENDOR);
//		
		Thread.sleep(7000);
	}
}
