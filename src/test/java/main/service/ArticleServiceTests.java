package main.service;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import main.exceptions.ArticleNotFoundException;
import main.repository.ArticleRepository;
import main.repository.ArticleTagRepository;
import main.repository.entities.Article;
import main.repository.entities.ArticleTag;
import main.service.ArticleService;

@RunWith(SpringRunner.class)
public class ArticleServiceTests {

	@InjectMocks
	private ArticleService service;
	
	@Mock
	private ArticleRepository repo;
	
	@Mock
	private ArticleTagRepository tagRepo;
	
	private Article testArticle;
	private ArticleTag testTag;
	
	private List<Article> testArticleList;
	private List<ArticleTag> testTagList;
	
	@Before
	public void init() {
		this.testArticleList = new ArrayList<Article>();
		this.testArticleList.add(testArticle);		
		this.testTagList = new ArrayList<ArticleTag>();
		this.testTag = new ArticleTag("tag_name");
		testTagList.add(testTag);
		this.testArticle = new Article("Fusion", "www.url.com", testTagList);
	}

	@Test
	public void createArticleTest() {
		Mockito.when(repo.save(testArticle)).thenReturn(testArticle);
		assertTrue("Article has not been created", service.createArticle(testArticle).getName().equals("Fusion"));
		Mockito.verify(repo).save(testArticle);
	}

	@Test
	public void updateArticleTest() {
		Mockito.when(repo.getOne(1L)).thenReturn(testArticle);
		Mockito.when(repo.save(testArticle)).thenReturn(testArticle);
		assertTrue("Article has not been updated", service.updateArticle(testArticle, 1L).getName().equals("Fusion"));
		Mockito.verify(repo).getOne(1L);
		Mockito.verify(repo).save(testArticle);
	}

	@Test
	public void getArticlesTest() {		
		Mockito.when(repo.findAll()).thenReturn(testArticleList);
		assertTrue("Returned no articles", service.getArticles().size() > 0);
		Mockito.verify(repo).findAll();
	}
	
	@Test
	public void findArticleByIDTest() {
		Mockito.when(repo.findById(1L)).thenReturn(Optional.of(testArticle));
		assertTrue("Returned no tags", service.findArticleByID(1L).getName().equals(testArticle.getName()));
		Mockito.verify(repo).findById(1L);
	}
	
	@Test (expected = ArticleNotFoundException.class)
	public void getArticleTagExceptionTest() {		
		Mockito.when(repo.findById(100L)).thenThrow(new ArticleNotFoundException());
		service.findArticleByID(100L);
		
	}
	
	@Test
	public void toggleFavouriteTest() {
		Mockito.when(repo.findById(1L)).thenReturn(Optional.of(testArticle));
		testArticle.setFavourite(!testArticle.getFavourite());
		assertTrue("Article is not Favourite", repo.findById(1L).get().getFavourite());
		Mockito.verify(repo).findById(1L);
	}	
	
	@Test
	public void deleteArticleTest() {
		service.deleteArticle(1L);
		Mockito.verify(repo).deleteById(1L);
	}

}
