package datadrivenTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XML_ParameterizationTest {
@Test
public void loginTest(XmlTest xml) throws InterruptedException {
	WebDriverManager.edgedriver().setup();
	WebDriver driver=new EdgeDriver();
	driver.manage().window().maximize();
	driver.get(xml.getParameter("url"));
	 
	long timeouts=Long.parseLong(xml.getParameter("time"));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeouts));
	
	driver.findElement(By.id("email")).sendKeys(xml.getParameter("user"));
	driver.findElement(By.id("password")).sendKeys(xml.getParameter("password"));
	driver.findElement(By.id("last")).click();
	
	Thread.sleep(3000);
	driver.quit();
	
	
}

}
