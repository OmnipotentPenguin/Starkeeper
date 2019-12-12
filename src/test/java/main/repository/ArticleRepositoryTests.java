package main.repository;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import main.repository.ArticleRepository;
import main.repository.entities.Article;
import main.service.ArticleService;

@RunWith(SpringRunner.class)
public class ArticleRepositoryTests {

	@InjectMocks
	private ArticleService service;

	@Mock
	private ArticleRepository repo;
	
	@Test
	public void getArticlesTest() {		
		List<Article> articles = new ArrayList<Article>();
		articles.add(new Article("article_name", "www.url.com"));		
		Mockito.when(repo.findAll()).thenReturn(articles);		
		assertTrue("Returned no articles", service.getArticles().size() > 0);
		Mockito.verify(repo, times(1)).findAll();
	}
	
}
