package sagaroza;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_1 extends BaseTest{
	@Test
	public void FillForm() {
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Automation");
		driver.hideKeyboard();
		driver.findElement(By.xpath("android.widget.RadioButton[@text='Male']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		scrollToElementAction("Argentina");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		//Negative test - Assert text of error msg
		//String toastMsg = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		//Assert.assertEquals(toastMsg, "Please enter your name");
		List<String> productList = new ArrayList<>();
		productList.add("Jordan 6 Rings");
		productList.add("Air Jordan 1 Mid SE");
		
		for(String product : productList) {
			scrollToElementAction(product);
			
			int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
			
			for(int i=0;i<productCount;i++) {
				String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
				
				if(productName.equalsIgnoreCase(product)) {
					driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				}
			}
			
		}
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		webDriverWait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		//String selectedProduct = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		//Assert.assertEquals(selectedProduct, "Jordan 6 Rings");
		
		List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		double totalPrice = 0;
		for(int i = 0;i<productPrices.size();i++) {
			totalPrice += Double.parseDouble(productPrices.get(i).getText().substring(1));
		}
		
		Assert.assertEquals('$'+totalPrice,driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText());
	}
}
