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

public class SwipeDemo extends BaseTest{
	
	@Test
	public void SwipeDemoTest() throws MalformedURLException, InterruptedException {
		//Click on Views	
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		//Click on Gallery
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		//Click on Photos
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Photos']")).click();
		WebElement firstImage = driver.findElement(By.xpath("(//android.widget.ImageView)[1]")); 
		Assert.assertEquals(firstImage.getAttribute("focusable"),"true");
		//Swipe
		swipeAction(firstImage, "left");
		Assert.assertEquals(firstImage.getAttribute("focusable"),"false");
	}
}
