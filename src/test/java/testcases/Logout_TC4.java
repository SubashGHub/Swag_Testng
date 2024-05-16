package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Logout_TC4 extends CheckOut_TC3{
	@Test(dependsOnMethods = "checkoutTC_3")
	public void clickFinishTC_4() {
		driver.findElement(By.id("finish")).click();
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
		System.out.println(driver.getTitle());
		System.out.println(driver.getClass());
		
		log.info("TC4 is Passed");
	}

}
