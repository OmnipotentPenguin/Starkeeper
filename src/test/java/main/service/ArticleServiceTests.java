package main.service;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import main.repository.entities.Article;
import main.rest.ArticleController;
import main.service.ArticleService;

@RunWith(SpringRunner.class)
public class ArticleServiceTests {

	@InjectMocks
	private ArticleController controller;

	@Mock
	private ArticleService service;

	@Test
	public void createArticleTest() {
		Article testArticle = new Article("article_name", "www.url.com");
		Mockito.when(service.createArticle(testArticle)).thenReturn(testArticle);
		assertTrue("Article has not been created", service.createArticle(testArticle).getName().equals("article_name"));
		Mockito.verify(service).createArticle(testArticle);
	}

	@Test
	public void updateArticleTest() {
		Article newArticle = new Article("article_replacement", "www.url2.com");
		Mockito.when(service.updateArticle(newArticle, 1L)).thenReturn(newArticle);
		assertTrue("Article has not been updated", service.updateArticle(newArticle, 1L).getName().equals("article_replacement"));
		Mockito.verify(service).updateArticle(newArticle, 1L);
	}

	@Test
	public void deleteArticleTest() {
		Mockito.when(service.deleteArticle(1L)).thenReturn("Article Deleted");
		assertTrue("Article has not been deleted", service.deleteArticle(1L).equals("Article Deleted"));
		Mockito.verify(service).deleteArticle(1L);
	}

	@Test
	public void getArticlesTest() {
		List<Article> articles = new ArrayList<Article>();
		articles.add(new Article("article_name", "www.url.com"));
		Mockito.when(service.getArticles()).thenReturn(articles);
		assertTrue("Returned no articles", service.getArticles().size() > 0);
		Mockito.verify(service).getArticles();
	}

}
