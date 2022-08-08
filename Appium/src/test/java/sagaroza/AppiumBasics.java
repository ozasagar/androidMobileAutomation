package sagaroza;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class AppiumBasics extends BaseTest{
	
	@Test
	public void WifiSettingsName() throws MalformedURLException {
		//Tap preference option
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();	
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Wifi settings']")).click();
		String popTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(popTitle, "WiFi settings");
		driver.findElement(By.id("android:id/edit")).sendKeys("Automation");
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();		
	}
}
