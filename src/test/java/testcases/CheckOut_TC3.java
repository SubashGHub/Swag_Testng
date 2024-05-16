package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckOut_TC3 extends AddToCart_TC2{
	
	@Test(dataProvider = "checkoutData", dependsOnMethods = {"addToCartTC_2"})
	public void checkoutTC_3(String fname, String lname, String zip) {
				
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.id("first-name")).sendKeys(fname);
		driver.findElement(By.id("last-name")).sendKeys(lname);
		driver.findElement(By.id("postal-code")).sendKeys(zip);
		driver.findElement(By.id("continue")).click();
		System.out.println(driver.getTitle());
		System.out.println(driver.getClass());
		
		log.info("TC3 is Passed");

	}
	
	@DataProvider(indices = 0)
	public String[][] checkoutData() {
		String arr[][] = { { "rajesh", "kumar", "123-446" }

		};
		return arr;
	}

}
