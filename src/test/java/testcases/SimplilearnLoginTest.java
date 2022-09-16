package testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;

public class SimplilearnLoginTest extends BaseClass {
	
	@Test
	public void Test1(){
        
       LoginPage Lp = new LoginPage(driver);
       Lp.login("Abc@xyz.com","Abc@1234");
       
        // step 6 - validate error message
        WebElement Error = driver.findElement(By.id("msg_box"));
        
        String ActError = Error.getText();
        String ExpError = "The email or password you have entered is invalid.";
        
        if(ActError.equals(ExpError)) {
        	System.out.println("TEST CASE PASSED");
        }else {
        	System.out.println("TEST CASE FAILED");
        }
        
        /*
        // step 6 - validate error message
        WebElement Error = driver.findElement(By.id("msg_box"));
        
        String ActError = Error.getText();
        String ExpError = "The email or password you have entered is invalid.";
        
        //Assert.assertFalse(Error.isDisplayed());
        
        Assert.assertEquals(ActError, ExpError);
        */
	}
      
	@Test
        @Parameters({"uname","pwd"})
    	public void Test2(String UserName, String Password){
            
           LoginPage Lp = new LoginPage(driver);
           Lp.login(UserName,Password);
          
     
	}

	@Test
	public void Test3(){
        
		String UserName = sheet.getRow(1).getCell(0).getStringCellValue();
        String Password = sheet.getRow(1).getCell(1).getStringCellValue();

       LoginPage Lp = new LoginPage(driver);
       Lp.login(UserName,Password);
	}
	
}
