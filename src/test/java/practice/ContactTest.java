package practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Fireflink_ninza_CRM.GenericUitility.BaseClass;
import Fireflink_ninza_CRM.objectRepository.ContactsPage;
import Fireflink_ninza_CRM.objectRepository.CreateCampaignsPage;
import Fireflink_ninza_CRM.objectRepository.CreateContactPage;
import Fireflink_ninza_CRM.objectRepository.DashboardPage;

@Listeners(Fireflink_ninza_CRM.GenericUitility.ListnerImpl.class)
public class ContactTest extends BaseClass {

	@Test(groups = "RegressionSuite")
	public void tc_002_CreateContact() throws Exception {
		
		String CONTACTNAME = fUtil.readDataFromFile("Contacts", 7, 2);
		String ORGANIZATION = fUtil.readDataFromFile("Contacts", 7, 3);
		String MOBILE = fUtil.readDataFromFile("Contacts", 7, 4);
		String TITLE = fUtil.readDataFromFile("Contacts", 7, 5);
		String CAMPAIGN = fUtil.readDataFromFile("Contacts", 7, 6);
		
		DashboardPage dp = new DashboardPage(driver);
		ContactsPage cp = new ContactsPage(driver);
//		CreateCampaignsPage ccp = new CreateCampaignsPage(driver);
		CreateContactPage ccp = new CreateContactPage(driver);
		
		
		dp.getContactsLink().click();
		Reporter.log("Contact link clicked",true);
		
		cp.getCreateContactBtn().click();
		Reporter.log("Create Contact Button clicked",true);
		
//		Assert.fail();
		ccp.createContact(driver, CONTACTNAME, ORGANIZATION, MOBILE, TITLE);
		
		Reporter.log("Contact has been created",true);
		Thread.sleep(7000);
		
		
		
	}
}
