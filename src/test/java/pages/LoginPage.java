package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	//*************************Objects************************
	
	@FindBy(linkText = "Log in")
	WebElement LoginLink;
	
	@FindBy(name = "user_login")
	WebElement UserName;
	
	@FindBy(id = "password")
	WebElement Password;
	
	@FindBy(className = "rememberMe")
	WebElement Checkbox;
	
	@FindBy(name = "btn_login")
	WebElement LoginButton;
	
	public LoginPage(WebDriver basedriver) {
		this.driver = basedriver;
		PageFactory.initElements(basedriver, this);
	}

	//***********************Methods***************************
	public void login(String Usernameval,String Passval) {
		
		// Step 1 - Click on Log in
        
        LoginLink.click();
        
        // step 2 - Enter username
        
        UserName.sendKeys(Usernameval);
        
        // step 3 - Enter password
        
        Password.sendKeys(Passval);
        
        // step 4 - click remember me
        
        Checkbox.click();
        
        // step 5 - click login button
        
        LoginButton.click();
	}
	
	public void UiValidation() {
		
		
	}
}
