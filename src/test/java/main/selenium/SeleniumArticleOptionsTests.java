/*
package main.selenium;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import main.pom.StarKeeperPOM;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SeleniumArticleOptionsTests {

	@LocalServerPort
	private int port;

	private WebDriver driver;
	StarKeeperPOM starkeeper = new StarKeeperPOM();
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		ChromeOptions opt = new ChromeOptions();
		opt.setHeadless(true);
		this.driver = new ChromeDriver(opt);
		this.driver.manage().window().fullscreen();
	}
	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void testCreateArticle() throws InterruptedException {
		for (int i=0; i<10;i++){
			try {
				this.driver.get(starkeeper.host+port+starkeeper.skNewArticle);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				this.driver.findElement(starkeeper.articlesButton).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				assertEquals("Google Home", this.driver.findElement(starkeeper.findRowOneArticleName).getText());
				this.driver.findElement(starkeeper.articlesRowOneDelete).click();
			}
			catch(NoSuchElementException e){
				driver.navigate().refresh();
			}
		}
	}
	
	@Test
	public void testDeleteArticle() throws InterruptedException {
		for (int i=0; i<10;i++) {
			try {
				this.driver.get(starkeeper.host + port + starkeeper.skNewArticle);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				this.driver.findElement(starkeeper.submitButton).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				this.driver.findElement(starkeeper.articlesButton).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				this.driver.findElement(starkeeper.articlesRowOneDelete).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				assertEquals("Google Home", this.driver.findElement(starkeeper.findRowOneArticleName).getText());
				this.driver.findElement(starkeeper.articlesRowOneDelete).click();
			} catch (NoSuchElementException e) {
				driver.navigate().refresh();
			}
		}
	}
	
@Test
	public void testFavouriteArticle() throws InterruptedException {
		for (int i=0; i<10;i++) {
			try {
				this.driver.get(starkeeper.host+port+starkeeper.skNewArticle);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				this.driver.findElement(starkeeper.nameInput).sendKeys("BBC");
				this.driver.findElement(starkeeper.submitButton).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				this.driver.findElement(starkeeper.homeButton).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				this.driver.findElement(starkeeper.homeLatestRowOneFavourite).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				assertEquals("BBC", this.driver.findElement(starkeeper.findHomeFavouriteRowOneName).getText());
				this.driver.findElement(starkeeper.homeFavouriteRowOneDelete).click();
			} catch (NoSuchElementException e) {
				driver.navigate().refresh();
			}
		}
	}
}
*/