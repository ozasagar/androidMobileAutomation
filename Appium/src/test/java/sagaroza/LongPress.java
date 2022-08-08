package sagaroza;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class LongPress extends BaseTest{
	
	@Test
	public void LongPressGesture() throws MalformedURLException, InterruptedException {
		//Click Views
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		//Click Expandable Lists
		driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']")).click();
		//Click Custom Adapter
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		longPressAction(element);
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
		String menuText = driver.findElement(By.id("android:id/title")).getText();
			
	}
}
