package practice;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Fireflink_ninza_CRM.GenericUitility.BaseClass;
@Listeners(Fireflink_ninza_CRM.GenericUitility.ListnerImpl.class)
public class TestNGPractice extends BaseClass {

//	@Test(priority = -1)
//	public void sampleTest() {
//		System.out.println("TestNG testing");
//	}
//	
//	@Test(dependsOnMethods = "sampleTest")
//	public void create() {
//		Assert.fail();
//		System.out.println("Create");
//	}
//	
//	@Test(dependsOnMethods = "create")
//	public void modify() {
//		System.out.println("modify");
//	}
//	
//	@Test
//	public void delete() {
//		System.out.println("delete");
//	}
//	
//	@Test(dataProvider = "getData")
//	public void run(String name,int id) {
//		System.out.println();
//	}
//	
//	@DataProvider
//	public Object[][] getData(){
//		Object[][] data = new Object[4][2];
//		
//		data[0][0] = "Ironman";
//		data[0][1] = 1;
//		
//		data[1][0] = "Batman";
//		data[1][1] = 2;
//		
//		data[2][0] = "Superman";
//		data[2][1] = 3;
//		
//		data[3][0] = "Spiderman";
//		data[3][1] = 4;
//		
//		return data;
//		
//	}
//	
//	
//	@Test
//	public void running() {
//		
//		System.out.println("Step 1");
//		
//		System.out.println("Step 2");
//		
//		Assert.assertEquals(1, 1);
//		System.out.println("Step 3");
//		
//		System.out.println("Step 4");
//		
//		Assert.assertEquals("a", "a");
//		
//		System.out.println("Step 5");
//	}
	
	
//	@Test
//	public void regoinalregressionsuite() {
//		System.out.println("regional regession suite");
//	}
//	
	
	@Test(retryAnalyzer = Fireflink_ninza_CRM.GenericUitility.RetryAnalyzerImpl.class)
	public void sample() {
//		Assert.fail();
		System.out.println("sample testing");
	}
	
	@Test
	public void run() {
		System.out.println();
	}
	
}
