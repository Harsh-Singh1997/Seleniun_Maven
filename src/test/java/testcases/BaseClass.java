package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
	XSSFWorkbook wbook;
	XSSFSheet sheet;
	
	WebDriver driver;
	
	@BeforeSuite
	public void DataSetUp() throws IOException {
		FileInputStream fis = new FileInputStream("exceldata.xlsx");
        
        wbook = new XSSFWorkbook(fis);
        sheet = wbook.getSheet("Sheet1");


	}
	
	@AfterSuite
	public void DataClean() throws IOException{
		
		wbook.close();
	}
	
	@BeforeMethod
	public void SetUp() {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        
        driver = new ChromeDriver();
        
        driver.get("https://www.simplilearn.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS );	
	}

	@AfterMethod
	public void TearDown() {
		
		// step 7 - close the browser
        driver.close();
	}
}
