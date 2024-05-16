package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCart_TC2 extends Login_TC1{
	
	@Test(dependsOnMethods = { "loginTC_1" })
	public void addToCartTC_2() {
		
		WebElement filter = driver.findElement(By.xpath("//select[@data-test='product-sort-container']"));
		Select sc = new Select(filter);
		sc.selectByValue("lohi");
		driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
		driver.findElement(By.xpath("//a[@data-test='shopping-cart-link']")).click();
		
		Assert.assertEquals(driver.getTitle(), "Swag Labs", "Title Mismatch");
		System.out.println(driver.getTitle());
		System.out.println(driver.getClass());
		log.info("TC2 is Passed");

	}

}
