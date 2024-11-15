package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import dev.failsafe.internal.util.Durations;

/**
 * This class consists of generic methods related to selenium
 * @author pooja
 */
public class SeleniumUtility {
	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
   public void maximizeWindow(WebDriver driver) 
   {
	 driver.manage().window().maximize();
   }

   /**
    * This method is used to minimize the window
    * @param driver
    */
    public void minizeWindow(WebDriver driver) 
    {
      driver.manage().window().minimize();
    }
    /**
     * This method is used to wait implicitly
     * @param driver
     */
    public void addImplicitlyWait(WebDriver driver) 
    {
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      
    }
    /**
     * This method is used to wait explicitly
     * @param driver
     * @param element
     */
    public void WaitForElementToBeVisible(WebDriver driver, WebElement element)
    {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.visibilityOf(element));
 	
    }
    /**
     * This method will handle drop down by index
     * @param element
     * @param index
     */
    public void handleDropdown(WebElement element, int index) {
    	Select sel = new Select(element);
    	sel.selectByIndex(index);
    }
    /**
     * This method will handle drop down by value
     * @param element
     * @param value
     */
     public void handleDropdown(WebElement element,String value) {
    	 Select sel = new Select(element);
    	 sel.selectByValue(value);
     }
     /**
      * This method will handle drop down by visibleText
      * @param visibleText
      * @param element
      */
     
     public void handleDropdown(String visibleText, WebElement element)
     {
    	 Select sel = new Select(element);
    	 sel.selectByVisibleText(visibleText);
     }
     /**
      * This method will perform mouse overing action
      * @param driver
      * @param element
      */
     public void mouseOverAction(WebDriver driver, WebElement element) {
    	 Actions act = new Actions(driver);
    	 act.moveToElement(element).perform();
     }
     /**
      * This method will perform double click action
      * @param driver
      * @param element
      */
     public void doubleClickAction(WebDriver driver, WebElement element) {
    	 Actions act = new Actions(driver);
    	 act.doubleClick(element).perform();
     }
     /**
      * This method will perform right click action
      * @param driver
      * @param element
      */
     public void rightClickAction(WebDriver driver, WebElement element) {
    	 Actions act = new Actions(driver);
    	 act.contextClick(element).perform();
     }
     /**
      * This method will perform ClickAndHold action
      * @param driver
      * @param element
      */
     public void clickAndHoldAction(WebDriver driver, WebElement element) {
    	 Actions act = new Actions(driver);
    	 act.clickAndHold(element).perform();
     }
     /**
      * This method will perform Release action
      * @param driver
      * @param element
      */
     public void ReleaseAction(WebDriver driver, WebElement element) {
    	 Actions act = new Actions(driver);
    	 act.release(element).perform();
     }
    
     /**
      * This method will perform Drag and Drop action
      * @param driver
      * @param element
      */
     public void DragAndDropAction(WebDriver driver, WebElement src,WebElement target) {
    	 Actions act = new Actions(driver);
    	 act.dragAndDrop(src,target).perform();
     }
     
    /**
     * This method is handle frame by idOrName
     * @param driver
     * @param idOrName
     */
     
    public void handleFrame(WebDriver driver,String idOrName)
    {
    	driver.switchTo().frame(idOrName);
    }
    
    /**
     * This method will handle frame by index
     * @param driver
     * @param element
     */
    public void handleFrame(WebDriver driver,WebElement element)
    {
      driver.switchTo().frame(element);	
    }
    
    /**
     * This method will switch to parent frame
     * @param driver
     */
    public void switchToParentframe(WebDriver driver)
    {
    	driver.switchTo().parentFrame();
    }
    
    /**
     * This method will navigate to main page
     * @param driver
     */
    public void switchToMainPage(WebDriver driver) 
    {
    	driver.switchTo().defaultContent();
    }
    /**
     * This method will scroll to particular web element
     * @param driver
     * @param element
     */
    public void ScrollToElementAction(WebDriver driver,WebElement element)
    {
    Actions act = new Actions(driver);
    act.scrollToElement(element).perform();;
    }
    
    /**
     * This method will randomly scroll the page up by 500 units
     * @param driver
     */
    public void scrollUpAction(WebDriver driver)
    {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,-500", "");
    	
   }
    /**
     * This method will randomly scroll the page down by 500 units
     * @param driver
     */
    public void scrollDownAction(WebDriver driver)
    {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500", "");
    }
    /**
     * This method will scroll to element using java script executor
     * @param driver
     * @param element
     */
    public void scrollToElementJavaScript(WebDriver driver,WebElement element)
    {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView();", element);
    }
    /**
     * This method will take screen shot and return the path
     * @param driver
     * @param screenshotName
     * @return
     * @throws IOException
     */
    public String captureScreenShot(WebDriver driver,String screenshotName) throws IOException
    {
    	TakesScreenshot ts = (TakesScreenshot) driver;
    	File src = ts.getScreenshotAs(OutputType.FILE);
    	File dst = new File(".\\Screenshot\\"+screenshotName+".png");
    	Files.copy(src, dst);
    	
		return dst.getAbsolutePath(); //Extent Reports(Third party tool)
    	
    	
    }


    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
