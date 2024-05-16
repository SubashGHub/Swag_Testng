package testcases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login_TC1 extends SW_BaseClass {

	@Test(dataProvider = "loginData")
	public void loginTC_1(String username, String pwd) {
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("login-button")).click();
		
		Assert.assertEquals(driver.getTitle(), "Swag Labs", "Title Mismatch");
		log.info("TC1 is Passed");

	}

	@DataProvider(indices = 0)
	public String[][] loginData() throws IOException {
		
		XSSFWorkbook wb = null;
		FileInputStream strm = null;
		
		try {
			strm = new FileInputStream("D:\\Selenium\\Swag_Project\\Logindata.xlsx");
			wb = new XSSFWorkbook(strm);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		XSSFSheet sht = wb.getSheet("Sheet1");
		int row = sht.getLastRowNum();
		int clmn = sht.getRow(1).getLastCellNum();

		String arr[][] = new String[row][clmn];
		
		DataFormatter fmt = new DataFormatter();

		for (int i = 1; i <= row; i++) {
			for (int j = 0; j < clmn; j++) {
				XSSFCell celldata = sht.getRow(i).getCell(j);
				arr[i - 1][j] = fmt.formatCellValue(celldata);
			}
		}
		wb.close();
		strm.close();
		return arr;
	}

	

}
