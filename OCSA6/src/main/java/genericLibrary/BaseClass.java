package genericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;



public class BaseClass {
	public WebDriver driver;
	public DataUtility du=new DataUtility();
	public static WebDriver listenerDriver;
	@BeforeClass(alwaysRun=true)
	public void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		listenerDriver=driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public void loginApp() throws IOException
	{
		driver.get(du.getDatafromProperties("url"));
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
	}
	@AfterMethod(alwaysRun=true)
	public void logoutApp() 
	{
		driver.findElement(By.id("logoutLink")).click();
	}
	@AfterClass(alwaysRun=true)
	public void closeBrowser()
	{
		
	}

}
