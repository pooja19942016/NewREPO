package practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNGPractice {
	@Test(priority=1)
	public void methodFirst()
	{
	  Reporter.log("Hi from 1st");	
	}
	@Test( enabled = true)
	public void methodSecond() 
	{
		Reporter.log("Hi from second");
	}
	@Test(priority=3)
	public void methodThird()
	{
		Reporter.log("Hi from Third");
	}
}
