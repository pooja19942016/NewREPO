package genericUtilities;
import java.io.IOException;
import java.sql.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.AllProductsPage;
import objectRepository.LoginPage;
/**
 * This class consists of basic configuration annotations of TestNG 
 * @author pooja
 */
public class BaseClass {
	
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public SeleniumUtility sUtil = new SeleniumUtility();
	
	public WebDriver driver;
	
	/*Used for Listeners*/
	public static WebDriver sdriver;

  @BeforeSuite(groups={"Smoke","Regression"})
  public void bsConfig()
 {
	System.out.println("------Database Connection Successful--------");
 }
//@Parameters("browser")
//@BeforeTest
@BeforeClass(alwaysRun= true)
public void bcConfig(/*String BROWSER*/) throws IOException
{
	/*For Cross Browser Execution*/
//	if(BROWSER.equalsIgnoreCase("Edge"))
//	{
//		driver = new EdgeDriver();
//	}
//	else if(BROWSER.equalsIgnoreCase("Chrome"))
//	{
//		driver = new ChromeDriver();
//	}
//	else
//	{
//		driver = new EdgeDriver();
//	}
	
	String URL = pUtil.readDataFromPropertyFile("url");
	
	driver = new EdgeDriver();
	
	sUtil.maximizeWindow(driver);
	sUtil.addImplicitlyWait(driver);
	
	driver.get(URL);
	
	System.out.println("------Browser launch Successfully------");
	
	/*Used for Listeners*/
	sdriver = driver;
}
@BeforeMethod(alwaysRun= true)
public void bmConfig() throws IOException
{
	String USERNAME = pUtil.readDataFromPropertyFile("username");
    String PASSWORD = pUtil.readDataFromPropertyFile("password");
	
    LoginPage lp = new LoginPage(driver);
    lp.loginToApp(USERNAME, PASSWORD);
    
    System.out.println("------Login of Application Successfully------");
	
}

@AfterMethod(alwaysRun= true)
public void amConfig()
{
	AllProductsPage app = new AllProductsPage(driver);
	app.logoutOfApp();
	System.out.println("------Logout Of Application Successfully------");
	
}
@AfterTest
//@AfterClass(alwaysRun= true)
public void acConfig()
{
  driver.quit();
  System.out.println("------Browser closure successfully------");	
}
@AfterSuite(alwaysRun= true)
public void asConfig()
{
	System.out.println("------Database closure Successfully------");
}

}
