package Fireflink_ninza_CRM.GenericUitility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImpl implements IRetryAnalyzer{

	int count = 0;
	int retryCount = 3;
	@Override
	public boolean retry(ITestResult result) {
		
		while(count<retryCount) {
			count++;
			return true;
		}
		
		return false;
	}
	
	

}
