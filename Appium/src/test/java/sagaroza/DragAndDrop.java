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

public class DragAndDrop extends BaseTest{
	
	@Test
	public void DragAndDropTest() throws MalformedURLException, InterruptedException {
		//Click on Views	
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		WebElement dragDot1 = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		//Drag Drop
		dragAndDrop(dragDot1,630,560);
		WebElement resultText = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text"));
		Assert.assertEquals(resultText.isDisplayed(),"true");
		Assert.assertEquals(resultText.getText(), "Dropped!");
	}
}
