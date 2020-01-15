package main.service;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import main.repository.entities.Article;
import main.repository.entities.ArticleTag;
import main.rest.ArticleController;
import main.service.ArticleService;

@RunWith(SpringRunner.class)
public class ArticleServiceTests {

	@InjectMocks
	private ArticleController controller;

	@Mock
	private ArticleService service;
	
	private Article testArticle;
	private ArticleTag testTag;
	
	private List<ArticleTag> testTagList;
	
	@Before
	public void init() {		
		this.testTagList = new ArrayList<ArticleTag>();
		this.testTag = new ArticleTag("tag_name");
		testTagList.add(testTag);
		this.testArticle = new Article("Fusion", "www.url.com", testTagList);
	}

	@Test
	public void createArticleTest() {
		Mockito.when(service.createArticle(testArticle)).thenReturn(testArticle);
		assertTrue("Article has not been created", service.createArticle(testArticle).getName().equals("Fusion"));
		Mockito.verify(service).createArticle(testArticle);
	}

	@Test
	public void updateArticleTest() {
		Mockito.when(service.updateArticle(testArticle, 1L)).thenReturn(testArticle);
		assertTrue("Article has not been updated", service.updateArticle(testArticle, 1L).getName().equals("Fusion"));
		Mockito.verify(service).updateArticle(testArticle, 1L);
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
	
	@Test
	public void addTagToArticleTest() {
		Mockito.when(service.addTagToArticle(testArticle.getId(),testTag)).thenReturn(testArticle);
		assertTrue("Tag has not been added", service.addTagToArticle(testArticle.getId(),testTag).getName().equals("Fusion"));
		Mockito.verify(service).addTagToArticle(testArticle.getId(),testTag);
	}

}
