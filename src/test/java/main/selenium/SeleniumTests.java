package main.selenium;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;

public class SeleniumTests {
	
	private WebDriver driver;
	
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\git\\Starkeeper\\src\\main\\resources\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().window().fullscreen();
	}
	public void tearDown() {
		driver.quit();
	}
	/*
	@Test
	public void testSeleniumExample() throws InterruptedException {
		setup();
		
		this.driver.get("http://www.google.co.uk");
		this.driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("What is the best web browser?");
		this.driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys(Keys.ENTER);
		assertEquals("Chrome", this.driver.findElement(By.xpath("/html/body/div[7]/div[3]/div[7]/div[1]/div[2]/div/div/g-scrolling-carousel/div[1]/div/a[1]/div/div[3]/div/div[2]")).getText());
		
		tearDown();
	}
	*/
}
