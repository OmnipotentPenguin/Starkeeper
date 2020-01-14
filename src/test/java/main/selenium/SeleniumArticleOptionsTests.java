package main.selenium;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import main.pom.StarKeeperPOM;

import org.junit.Test;

public class SeleniumArticleOptionsTests {
	
	private WebDriver driver;
	StarKeeperPOM starkeeper = new StarKeeperPOM();
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		
		this.driver = new ChromeDriver();
		this.driver.manage().window().fullscreen();
	}
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void testCreateArticle() throws InterruptedException {
		this.driver.get(starkeeper.skNewArticle);
		this.driver.findElement(starkeeper.nameInput).sendKeys("Google Home");
		this.driver.findElement(starkeeper.descriptionInput).sendKeys("The homepage for Google.com");
		this.driver.findElement(starkeeper.sourceInput).sendKeys("Google");
		this.driver.findElement(starkeeper.urlInput).sendKeys("google.com");
		this.driver.findElement(starkeeper.ratingInput).sendKeys("5");
		this.driver.findElement(starkeeper.tagInput).sendKeys("Search Engine");	
		this.driver.findElement(starkeeper.tagInput).sendKeys(Keys.ENTER);
		this.driver.findElement(starkeeper.tagInput).sendKeys("Homepage");	
		this.driver.findElement(starkeeper.tagInput).sendKeys(Keys.ENTER);	
		this.driver.findElement(starkeeper.submitButton).click();
		Thread.sleep(1000);
		this.driver.findElement(starkeeper.articlesButton).click();
		Thread.sleep(1000);
		assertEquals("Google Home", this.driver.findElement(starkeeper.findRowOneArticleName).getText());
		this.driver.findElement(starkeeper.articlesRowOneDelete).click();
	}
	
	@Test
	public void testDeleteArticle() throws InterruptedException {
		this.driver.get(starkeeper.skNewArticle);
		this.driver.findElement(starkeeper.nameInput).sendKeys("Google Home");
		this.driver.findElement(starkeeper.descriptionInput).sendKeys("The homepage for Google.com");
		this.driver.findElement(starkeeper.sourceInput).sendKeys("Google");
		this.driver.findElement(starkeeper.urlInput).sendKeys("google.com");
		this.driver.findElement(starkeeper.ratingInput).sendKeys("5");
		this.driver.findElement(starkeeper.tagInput).sendKeys("Search Engine");	
		this.driver.findElement(starkeeper.tagInput).sendKeys(Keys.ENTER);
		this.driver.findElement(starkeeper.tagInput).sendKeys("Homepage");	
		this.driver.findElement(starkeeper.tagInput).sendKeys(Keys.ENTER);	
		this.driver.findElement(starkeeper.submitButton).click();
		Thread.sleep(1000);
		this.driver.findElement(starkeeper.submitButton).click();
		Thread.sleep(1000);
		this.driver.findElement(starkeeper.articlesButton).click();
		Thread.sleep(1000);
		this.driver.findElement(starkeeper.articlesRowOneDelete).click();
		Thread.sleep(1000);
		assertEquals("Google Home", this.driver.findElement(starkeeper.findRowOneArticleName).getText());
		this.driver.findElement(starkeeper.articlesRowOneDelete).click();
	}
	
	@Test
	public void testFavouriteArticle() throws InterruptedException {
		this.driver.get(starkeeper.skNewArticle);
		this.driver.findElement(starkeeper.nameInput).sendKeys("BBC");
		this.driver.findElement(starkeeper.submitButton).click();
		Thread.sleep(1000);
		this.driver.findElement(starkeeper.homeButton).click();
		Thread.sleep(1000);
		this.driver.findElement(starkeeper.homeLatestRowOneFavourite).click();
		Thread.sleep(1000);
		assertEquals("BBC", this.driver.findElement(starkeeper.findHomeFavouriteRowOneName).getText());
		this.driver.findElement(starkeeper.homeFavouriteRowOneDelete).click();
	}
}
