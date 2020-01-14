package main.selenium;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;

import main.pom.StarKeeperPOM;

public class SeleniumHeaderButtonTests {
	
	private WebDriver driver;
	StarKeeperPOM starkeeper = new StarKeeperPOM();
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		this.driver = new ChromeDriver();
		this.driver.manage().window().fullscreen();
	}
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void testHomeToHomeButton() throws InterruptedException {
		this.driver.get(starkeeper.skHome);
		this.driver.findElement(starkeeper.homeButton).click();		
		assertEquals(starkeeper.skHome, this.driver.getCurrentUrl());
	}
	
	@Test
	public void testHomeToArticlesButton() throws InterruptedException {
		this.driver.get(starkeeper.skHome);
		this.driver.findElement(starkeeper.articlesButton).click();		
		assertEquals(starkeeper.skArticles, this.driver.getCurrentUrl());
	}
	
	@Test
	public void testHomeToNewArticle() throws InterruptedException {
		this.driver.get(starkeeper.skHome);
		this.driver.findElement(starkeeper.newArticleButton).click();		
		assertEquals(starkeeper.skNewArticle, this.driver.getCurrentUrl());
	}
	
	@Test
	public void testArticlesToHome() throws InterruptedException {
		this.driver.get(starkeeper.skArticles);
		this.driver.findElement(starkeeper.homeButton).click();		
		assertEquals(starkeeper.skHome, this.driver.getCurrentUrl());
	}
	
	@Test
	public void testArticlesToArticles() throws InterruptedException {
		this.driver.get(starkeeper.skArticles);
		this.driver.findElement(starkeeper.articlesButton).click();		
		assertEquals(starkeeper.skArticles, this.driver.getCurrentUrl());
	}
	
	@Test
	public void testArticlesToNewArticle() throws InterruptedException {
		this.driver.get(starkeeper.skArticles);
		this.driver.findElement(starkeeper.newArticleButton).click();		
		assertEquals(starkeeper.skNewArticle, this.driver.getCurrentUrl());
	}
	
	@Test
	public void testNewArticleToHome() throws InterruptedException {
		this.driver.get(starkeeper.skNewArticle);
		this.driver.findElement(starkeeper.homeButton).click();		
		assertEquals(starkeeper.skHome, this.driver.getCurrentUrl());
	}
	
	@Test
	public void testNewArticleToArticles() throws InterruptedException {
		this.driver.get(starkeeper.skNewArticle);
		this.driver.findElement(starkeeper.articlesButton).click();		
		assertEquals(starkeeper.skArticles, this.driver.getCurrentUrl());
	}
	
	@Test
	public void testNewArticleToNewArticle() throws InterruptedException {
		this.driver.get(starkeeper.skNewArticle);
		this.driver.findElement(starkeeper.newArticleButton).click();		
		assertEquals(starkeeper.skNewArticle, this.driver.getCurrentUrl());
	}
}
