package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage
{
	//Declaration
@FindBy(name ="add-to-cart") 
private WebElement addToCartBtn;

@FindBy(id ="shopping_cart_container")
private WebElement cartContainerLink;

//Initialization
public  ProductPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
//Utilization
public WebElement getAddToCartBtn() {
	return addToCartBtn;
}

public WebElement getCartContainerLink() {
	return cartContainerLink;
}
//Business library
/**
 * This method will check on add to cart button
 */
public void clickOnAddToCartButton()
{
	addToCartBtn.click();
}
/**
 * This method will click on cart container button 
 */
public void clickOnCartButton()
{
	cartContainerLink.click();
}
}