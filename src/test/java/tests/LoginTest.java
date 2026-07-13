package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest {
		
		@Test
		public void loginTest() {
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://www.saucedemo.com/");
		System.out.println("prueba de login ejecutada correctamente");
		
		driver.quit();
	}

}
