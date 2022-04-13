package testScript;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;

public class CreateCustomerTest extends BaseClass{
	@Test
	public void createCustomer() throws EncryptedDocumentException, IOException
	{
	Random r=new Random();
	int num=r.nextInt(10000);
	driver.findElement(By.id("container_tasks")).click();
	driver.findElement(By.cssSelector(".title.ellipsis")).click();
	driver.findElement(By.className("createNewCustomer")).click();
	driver.findElement(By.className("newNameField"))
	.sendKeys(num+du.getDatafromExcelsheet("Sheet1", 0, 0));
	driver.findElement(By.cssSelector("[placeholder='Enter Customer Description']"))
	.sendKeys("done");
	driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
	System.out.println("customer created");
	
}

}
