package practice;

import java.io.IOException;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.LoginPage;

public class AddProductToCartDDTandGU {
    
	public static void main(String[] args) throws IOException, InterruptedException {
	
	    //Create the object of Utility Classes
		ExcelFileUtility eUtil = new ExcelFileUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		//Read the common Data from property file 
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		//Read the Test Data from property file
		String PRODUCTNAME = eUtil.readDataFromExcel("Product", 1, 2);
	
		//step 1: Launch the browser
		WebDriver driver = new EdgeDriver();
				
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);

				
	    //step 2: Load the URL
		driver.get(URL);
				
//		//step 3: Login to application
//		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
//		driver.findElement(By.id("password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("login-button")).click();

		
		
		        // POM //
		LoginPage lp = new LoginPage(driver);
		lp.getUsernameEdt().sendKeys(USERNAME);
		lp.getPasswordEdt().sendKeys(PASSWORD);
		lp.getLoginBtn().click();
		
		
		
		
		
		//step 4: Click on a product
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).click();
		String productTitle = driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).getText();
				
				
		//step 5:Add product to CART
		driver.findElement(By.id("add-to-cart")).click();
				
		//step 6:
	    driver.findElement(By.className("shopping_cart_link")).click();
			 
			
		String ProductTitleInCart = driver.findElement(By.className("inventory_item_name")).getText();
			    
	    if(ProductTitleInCart.equalsIgnoreCase(productTitle))
		{
		   System.out.println("Product Successfully Added to cart");
	   	   System.out.println("PASS");
	   	   System.out.println(ProductTitleInCart);
	     }
		 else 
		{
		   System.out.println("Product Not Added to Cart -> FAIL");	
		}
				
	    //Step 7:LogOut of Application
		driver.findElement(By.id("react-burger-menu-btn")).click();
	    driver.findElement(By.linkText("Logout")).click();
				
	    System.out.println("Successfully LogOut");
				
      }
   }