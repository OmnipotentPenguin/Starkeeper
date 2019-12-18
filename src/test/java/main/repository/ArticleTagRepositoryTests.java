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

import main.repository.entities.Article;
import main.repository.entities.ArticleTag;
import main.service.ArticleTagService;

@RunWith(SpringRunner.class)
public class ArticleTagRepositoryTests {

	@InjectMocks
	private ArticleTagService service;

	@Mock
	private ArticleTagRepository repo;
	
	@Test
	public void getArticlesTest() {		
		List<ArticleTag> tags = new ArrayList<ArticleTag>();
		tags.add(new ArticleTag("tag_name"));		
		Mockito.when(repo.findAll()).thenReturn(tags);		
		assertTrue("Returned no tags", service.getArticleTags().size() > 0);
		Mockito.verify(repo, times(1)).findAll();
	}
	
}