package sagaroza;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTest extends MobileBrowserBaseTest{

	@Test
	public void BrowserDemoTest() {
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//span[@class=\"navbar-toggler-icon\"]")).click();
		driver.findElement(By.xpath("//a[contains(text(),\"Products\")]")).click();
		//Scroll before gets devops text
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)","");
		String text = driver.findElement(By.xpath("//a[contains(text(),'Devops')]")).getText();
		Assert.assertEquals(text, "Devops");
	}
}
