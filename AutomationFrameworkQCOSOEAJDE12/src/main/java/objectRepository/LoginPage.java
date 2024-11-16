package objectRepository;     

//**************POM PAGE*************************//

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage { //POM class should always end up with page
	//Rule 1:Create object separate POM class for web page 
	
	//Rule 2: Identify the Web Elements using annotations
	@FindBy(id = "user-name") private WebElement usernameEdt;
	
	@FindBy(id = "password") private WebElement passwordEdt;  //Edt-->TextFeild
	
	@FindBy(id = "login-button") private WebElement loginBtn;
	
	//Rule 3: Create a constructor and initialize the web elements using page factory
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
    //Rule 4: Provide getters to access the webElements
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	/**
	 * This method will perform login operation
	 * @param USERNAME
	 * @param PASSWORD
	 */
	//Rule 5: Provide Re-usable business library - operation to access the element
	public void loginToApp(String USERNAME, String PASSWORD) 
	{
		usernameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	
	}
	
	

}
