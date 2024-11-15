package Products;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.AllProductsPage;
import objectRepository.LoginPage;
import objectRepository.ProductPage;
import objectRepository.YourCartPage;
@Listeners(genericUtilities.ListenersImplementation.class)
public class AddProductToCartTest extends BaseClass {
@Test(groups="Smoke")
/*Test method or Test Script*/

public void AddProductToCart() throws IOException, InterruptedException{
			
	        //Read the Test Data from Excel file
			String PRODUCTNAME = eUtil.readDataFromExcel("Products", 1, 2);
			System.out.println(PRODUCTNAME);
		    
			//step 4: Click on a product
			Thread.sleep(3000);
			AllProductsPage app = new AllProductsPage(driver);
			String productTitle = app.clickOnProductName(driver, PRODUCTNAME);
					
			//step 5:Add product to CART
			ProductPage pp= new ProductPage(driver);
			pp.clickOnAddToCartButton();
			
			//Assert.fail();
				
			//step 6: Navigate to cart
			pp.clickOnCartButton();
				
			//Step 7:Validate in cart Page
			YourCartPage cp = new YourCartPage(driver);
			String ProductTitleInCart = cp.getProductTitle();
			
			//Step 8:Validate for Product details in cart	
		    Assert.assertEquals(ProductTitleInCart, productTitle);
	  
		    Assert.assertTrue(ProductTitleInCart.contains(ProductTitleInCart));
}
}
