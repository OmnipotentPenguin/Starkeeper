package main.pom;

import org.openqa.selenium.By;

public class StarKeeperPOM {

	public String host = "http://localhost:";
	public String skHome = "/StarKeeper/index.html";
	public String skArticles = "/StarKeeper/articles.html";
	public String skNewArticle = "/StarKeeper/create_article.html";

	public By homeButton = By.xpath("/html/body/nav/div/div[2]/ul[1]/li[1]/a");
	public By articlesButton = By.xpath("/html/body/nav/div/div[2]/ul[1]/li[2]/a");
	public By newArticleButton = By.xpath("/html/body/nav/div/div[2]/ul[2]/li/a");	
	
	public By nameInput = By.xpath("/html/body/div/div/div[2]/section/div[2]/div[1]/input");
	public By descriptionInput = By.xpath("/html/body/div/div/div[2]/section/div[2]/div[2]/textarea");
	public By sourceInput = By.xpath("/html/body/div/div/div[2]/section/div[2]/div[3]/input");
	public By urlInput = By.xpath("/html/body/div/div/div[2]/section/div[2]/div[4]/input");
	public By ratingInput = By.xpath("/html/body/div/div/div[2]/section/div[2]/div[5]/input");
	public By tagInput = By.xpath("/html/body/div/div/div[2]/section/div[2]/div[6]/span[2]/span[1]/span/ul/li/input");
	public By submitButton = By.xpath("/html/body/div/div/div[2]/section/div[2]/button");
	
	public By findRowOneArticleName = By.xpath("/html/body/div/div/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[2]");
	
	public By articlesRowOneFavourite = By.xpath("/html/body/div/div/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[7]/a[1]/i");
	public By articlesRowOneEdit = By.xpath("/html/body/div/div/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[7]/a[2]/i");
	public By articlesRowOneDelete = By.xpath("/html/body/div/div/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[7]/a[3]/i");
	
	public By homeLatestRowOneFavourite = By.xpath("/html/body/div/div[1]/div[2]/div[1]/div[4]/table/tbody/tr/td[7]/a[1]/i");
	
	public By homeFavouriteRowOneDelete = By.xpath("/html/body/div/div[1]/div[2]/div[1]/div[2]/table/tbody/tr/td[7]/a[3]/i");
	
	public By findHomeFavouriteRowOneName = By.xpath("/html/body/div/div[1]/div[2]/div[1]/div[2]/table/tbody/tr/td[2]");
}
