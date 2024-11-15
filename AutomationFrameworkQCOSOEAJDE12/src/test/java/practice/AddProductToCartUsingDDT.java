package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;



public class AddProductToCartUsingDDT 
{
public static void main(String[] args) throws IOException {
	//Read the common data from property file
FileInputStream	 fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
Properties p = new Properties();
p.load(fisp);
String URL = p.getProperty("url");
String USERNAME = p.getProperty("username");
String PASSWORD = p.getProperty("password");

//Launch
WebDriver driver= new EdgeDriver();

driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


//Url
driver.get(URL);

//Login Credentials
driver.findElement(By.id("user-name")).sendKeys(USERNAME);
driver.findElement(By.id("password")).sendKeys(PASSWORD);
driver.findElement(By.id("login-button")).click();

//Read the test data for Excel File
FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
Workbook wb = WorkbookFactory.create(fise);
Sheet sh =wb.getSheet("Products");
Row rw = sh.getRow(1);
Cell c1= rw.getCell(2);
String PRODUCTNAME =c1.getStringCellValue();
System.out.println(PRODUCTNAME);

















}
}
