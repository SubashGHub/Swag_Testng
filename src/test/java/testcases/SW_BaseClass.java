package testcases;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class SW_BaseClass {
	
	public WebDriver driver;
	public static Logger log;
	
	@BeforeClass
	@Parameters({"browser","url"})
	public void openApplication(String bwsr, String url) {
		
		log = Logger.getLogger("Swag Labs Project");
		PropertyConfigurator.configure(System.getProperty("user.dir")+"/Log4j.properties");
		
		if(bwsr.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			log.info("Opend in Chrome");
		}else if(bwsr.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			log.info("Opend in Edge");
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void closeApplication() {
		driver.close();
	}
}
