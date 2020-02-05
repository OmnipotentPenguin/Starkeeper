/*
package main.selenium;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.Test;

import main.pom.StarKeeperPOM;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SeleniumHeaderButtonTests {

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
	public void testHomeToHomeButton() throws InterruptedException {
		this.driver.get(starkeeper.host+port+starkeeper.skHome);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		this.driver.findElement(starkeeper.homeButton).click();		
		assertEquals(starkeeper.host+port+starkeeper.skHome, this.driver.getCurrentUrl());
	}
	
	@Test
	public void testHomeToArticlesButton() throws InterruptedException {
		this.driver.get(starkeeper.host+port+starkeeper.skHome);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		this.driver.findElement(starkeeper.articlesButton).click();		
		assertEquals(starkeeper.host+port+starkeeper.skArticles, this.driver.getCurrentUrl());
	}
	
	@Test
	public void testHomeToNewArticle() throws InterruptedException {
		this.driver.get(starkeeper.host+port+starkeeper.skHome);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		this.driver.findElement(starkeeper.newArticleButton).click();		
		assertEquals(starkeeper.host+port+starkeeper.skNewArticle, this.driver.getCurrentUrl());
	}
	
	@Test
	public void testArticlesToHome() throws InterruptedException {
		this.driver.get(starkeeper.host+port+starkeeper.skArticles);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		this.driver.findElement(starkeeper.homeButton).click();		
		assertEquals(starkeeper.host+port+starkeeper.skHome, this.driver.getCurrentUrl());
	}
	
	@Test
	public void testArticlesToArticles() throws InterruptedException {
		this.driver.get(starkeeper.host+port+starkeeper.skArticles);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		this.driver.findElement(starkeeper.articlesButton).click();		
		assertEquals(starkeeper.host+port+starkeeper.skArticles, this.driver.getCurrentUrl());
	}
	
	@Test
	public void testArticlesToNewArticle() throws InterruptedException {
		this.driver.get(starkeeper.host+port+starkeeper.skArticles);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		this.driver.findElement(starkeeper.newArticleButton).click();		
		assertEquals(starkeeper.host+port+starkeeper.skNewArticle, this.driver.getCurrentUrl());
	}
	
	@Test
	public void testNewArticleToHome() throws InterruptedException {
		this.driver.get(starkeeper.host+port+starkeeper.skNewArticle);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		this.driver.findElement(starkeeper.homeButton).click();		
		assertEquals(starkeeper.host+port+starkeeper.skHome, this.driver.getCurrentUrl());
	}
	
	@Test
	public void testNewArticleToArticles() throws InterruptedException {
		this.driver.get(starkeeper.host+port+starkeeper.skNewArticle);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		this.driver.findElement(starkeeper.articlesButton).click();		
		assertEquals(starkeeper.host+port+starkeeper.skArticles, this.driver.getCurrentUrl());
	}
	
	@Test
	public void testNewArticleToNewArticle() throws InterruptedException {
		this.driver.get(starkeeper.host+port+starkeeper.skNewArticle);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		this.driver.findElement(starkeeper.newArticleButton).click();		
		assertEquals(starkeeper.host+port+starkeeper.skNewArticle, this.driver.getCurrentUrl());
	}
}
*/
