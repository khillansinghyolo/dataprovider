import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class BaseTest {
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
	
}
