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

public class Assignment1 extends BaseTest{
	
	@Test
	public void Assignment() throws MalformedURLException, InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		//Click on ultra long message
		driver.findElement(By.id("io.appium.android.apis:id/two_buttons2ultra")).click();
		//Assert alter is open and then click ok btn
		WebElement alertTitleElement = driver.findElement(By.id("android:id/alertTitle"));
		Assert.assertEquals(alertTitleElement.isDisplayed(), true);
		driver.findElement(By.id("android:id/button1")).click();
		//Click on list option
		driver.findElement(AppiumBy.accessibilityId("List dialog")).click();
		Assert.assertEquals(alertTitleElement.isDisplayed(), true);
		driver.findElement(By.xpath("//android.widget.TextView[3]")).click();
		Assert.assertEquals(driver.findElement(By.id("android:id/message")).getText(), "You selected: 2 , Command three");
		driver.navigate().back();
		//Click on single choice list
		driver.findElement(AppiumBy.accessibilityId("Single choice list")).click();
		Assert.assertEquals(alertTitleElement.isDisplayed(), true);
		WebElement trafficCheckBox = driver.findElement(By.xpath("android.widget.CheckedTextView[3]"));
		trafficCheckBox.click();
		Assert.assertEquals(trafficCheckBox.getAttribute("checked"), "true");
		driver.findElement(By.xpath("android.widget.Button[2]")).click();
		//Click Text Entry dialog
		driver.findElement(AppiumBy.accessibilityId("Text Entry dialog")).click();
		Assert.assertEquals(alertTitleElement.isDisplayed(), true);
		driver.findElement(By.id("io.appium.android.apis:id/username_edit")).sendKeys("Automation");
		driver.findElement(By.id("io.appium.android.apis:id/password_edit")).sendKeys("Automation");
		driver.findElement(By.id("android:id/button1")).click();		
	}
}
