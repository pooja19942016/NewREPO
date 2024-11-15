package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class YourCartPage {
	
//Declaration

@FindBy(className = "inventory_item_name")
private WebElement productNameLink;

//Initialization
public YourCartPage(WebDriver driver)
{
  PageFactory.initElements(driver, this);
}

//Utilization
public WebElement getProductNameLink() {
	return productNameLink;
}
//Business library
/**
 * This method will capture the product title in cart and return to caller
 * @return
 */
public String getProductTitle()
{
	return productNameLink.getText();
}

}
