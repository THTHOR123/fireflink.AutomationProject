package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Fireflink_ninza_CRM.GenericUitility.BaseClass;
import Fireflink_ninza_CRM.objectRepository.CampaignsPage;
import Fireflink_ninza_CRM.objectRepository.CreateCampaignsPage;
import Fireflink_ninza_CRM.objectRepository.DashboardPage;

@Listeners(Fireflink_ninza_CRM.GenericUitility.ListnerImpl.class)
public class CampaignTest extends BaseClass{

	
	@Test(groups = "SmokeSuite")
	public void tc_001_CreateCampaignTest() throws Exception {
		
		String CAMPAIGNNAME = fUtil.readDataFromFile("Campaign", 1, 2);
		String TARGETSIZE = fUtil.readDataFromFile("Campaign", 1, 3);
		
		
		DashboardPage dp = new DashboardPage(driver);
		CampaignsPage cp = new CampaignsPage(driver);
//		CreateCampaign cc = new CreateCampaign()
		CreateCampaignsPage ccp = new CreateCampaignsPage(driver);
		
		dp.getCampaignsLink().click();
		wUtil.implicitlyWait(driver);
		
		cp.getCreateCampaignBtn().click();
		
		ccp.createCampaign(CAMPAIGNNAME, TARGETSIZE);
		
		Thread.sleep(7000);
		
		
	}
}
