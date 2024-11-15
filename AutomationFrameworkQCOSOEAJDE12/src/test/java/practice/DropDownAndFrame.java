package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;

public class DropDownAndFrame {
public static void main(String[] args) throws IOException {
	ExcelFileUtility eu = new ExcelFileUtility();
	PropertyFileUtility pu = new PropertyFileUtility();
	SeleniumUtility su = new SeleniumUtility();
	
	String URL = pu.readDataFromPropertyFile("url");
	String USERNAME = pu.readDataFromPropertyFile("username");
	String PASSWORD = pu.readDataFromPropertyFile("password");
	
	WebDriver driver = new EdgeDriver();
	
	su.maximizeWindow(driver);
	su.addImplicitlyWait(driver);
	
	driver.get(URL);
	
	driver.findElement(By.id("user-name")).sendKeys(USERNAME);
	driver.findElement(By.id("password")).sendKeys(PASSWORD);
	driver.findElement(By.id("login-button")).click();

	
 WebElement ele = driver.findElement(By.xpath("//span[text()='Name (A to Z)']"));
 su.handleDropdown(ele, 2);
	
}
}
