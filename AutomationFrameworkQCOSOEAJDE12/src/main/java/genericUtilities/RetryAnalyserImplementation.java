package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/*
 * This class provides implementation to IReryAnalyzer interface of TestNG
 * 
 * 
 * */
public class RetryAnalyserImplementation implements IRetryAnalyzer  {

	int count = 0;
	int retryCount = 5;
	@Override
	public boolean retry(ITestResult result)
	{
		if(count<retryCount)
		{
			count++;
			return true;
		}
	 return false;			
	}

}
