package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AddProductToCartAndValidate {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh =wb.getSheet("Products");
		Row rw = sh.getRow(1);
		Cell c1= rw.getCell(2);
		String PRODUCTNAME =c1.getStringCellValue();
		System.out.println(PRODUCTNAME);
	
      //step 1: Launch the browser
		WebDriver driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	 //step 2: Load the URL
		driver.get("https://www.saucedemo.com/");
		
	 //step 3: Login to application
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();

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
