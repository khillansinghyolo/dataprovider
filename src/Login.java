import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testing.utilities.TestUtils;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Login {

	public WebDriver driver;
	@BeforeTest()
	public void browser()
	{
		System.setProperty("webdriver.chrome.driver","../BDD/chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(90,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(90,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}	
	@Test(dataProvider ="getData")
	public void login(String user,String password ,String  validation )
	{
		driver.get("http://182.156.251.238/Wiz76QC/Default.aspx");
		driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys(user);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		
		
		String expectedTitle="Mr. System Administrator";
		String actualTitle=driver.getTitle();
		
		if(validation.equals("valid"))
		{
			if(expectedTitle.equals(actualTitle))
			{
				driver.findElement(By.xpath("//*[@id='rightNav']/descendant::i[1]")).click();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		else if(validation.equals("Invalid"))
		{
			if(expectedTitle.equals(actualTitle))
			{
				driver.findElement(By.xpath("//*[@id='rightNav']/descendant::i[1]")).click();
				Assert.assertTrue(false);
			}
			else
			{
				
				Assert.assertTrue(true);
			}	
		}
		//driver.findElement(By.xpath("//*[@id='rightNav']/descendant::i[1]")).click();
		//System.out.println("Successfully login and log out"+user+"------"+password);
	}
	@DataProvider(name="getData")
	public Object[][] getData() {
		
		Object[][] ob= {
				
				{"admin","password","Valid"},
				{"admn"	,"password","Invalid"},
				{"adm"	,"password","Invalid"},
				{"admin","afaew","Invalid"}
				};			
			return ob;		
	}
	@AfterTest()
	public void closeDriver()
	{
		driver.close();
	}
}
