package sagaroza;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {
		//Start server
		service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//sagar.oza//.appium//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		//Define UiAutomator
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 5 API 31");
		options.setChromedriverExecutable("Provide path to chrome driver exe");
		//options.setApp("C://Users//sagar.oza//Desktop//APKFiles//resources//ApiDemos-debug.apk");
		options.setApp("C://Users//sagar.oza//Desktop//APKFiles//resources//General-Store.apk");
		//Define android driver
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void longPressAction(WebElement element) {
		((JavascriptExecutor)driver).executeScript("mobile : longClickGesture", 
				ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),
						"duration",2000));
	}
	
	public void scrollToElementAction(String text) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text('"+text+"'));"));
	}
	
	public void scrollToEndAction() {
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
					 	"left", 100, "top", 100, "width", 200, "height", 200,
					 	"direction", "down",
					 	"percent", 3.0
					));
		}while(canScrollMore);
	}
	
	public void swipeAction(WebElement element, String direction) {
		((JavascriptExecutor)driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement)element).getId(),
				"direction",direction,
				"percent", 0.75
				));
	}
	
	public void dragAndDrop(WebElement source, int xCordinate, int yCordinate) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) source).getId(),
				"endX", xCordinate,
				"endY", yCordinate
			));
	}
	
	@AfterClass
	public void TearDown() {
		//Quit driver
		driver.quit();
		//Stop server
		service.stop();
	}
}
