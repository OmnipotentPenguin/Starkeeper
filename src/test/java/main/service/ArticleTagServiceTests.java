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

import java.util.Optional;

import main.exceptions.TagNotFoundException;
import main.repository.ArticleRepository;
import main.repository.ArticleTagRepository;
import main.repository.entities.Article;
import main.repository.entities.ArticleTag;

@RunWith(SpringRunner.class)
public class ArticleTagServiceTests {
	
	@InjectMocks
	private ArticleTagService service;
	
	@Mock
	private ArticleService artService;
	
	@Mock
	private ArticleTagRepository repo;
	
	@Mock
	private ArticleRepository artRepo;
	
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
	public void createArticleTagExistsTest() {
		Mockito.when(repo.existsTagByName(testTag.getName())).thenReturn(true);
		Mockito.when(repo.findTagByName(testTag.getName())).thenReturn(Optional.of(testTag));
		assertTrue("Tag has not been created", service.createArticleTag(testTag).getName().equals("tag_name"));
		Mockito.verify(repo).existsTagByName(testTag.getName());
		Mockito.verify(repo).findTagByName(testTag.getName());
	}
	
	@Test
	public void createArticleTagNewTest() {
		Mockito.when(repo.existsTagByName(testTag.getName())).thenReturn(false);
		Mockito.when(repo.save(testTag)).thenReturn(testTag);
		assertTrue("Tag has not been created", service.createArticleTag(testTag).getName().equals("tag_name"));
		Mockito.verify(repo).existsTagByName(testTag.getName());
		Mockito.verify(repo).save(testTag);
	}

	@Test
	public void updateArticleTagTest() {
		Mockito.when(repo.getOne(1L)).thenReturn(testTag);
		testTag.setName(testTag.getName());
		Mockito.when(repo.save(testTag)).thenReturn(testTag);
		assertTrue("Tag has not been updated", service.updateArticleTag(testTag, 1L).getName().equals("tag_name"));
		Mockito.verify(repo).getOne(1L);
		Mockito.verify(repo).save(testTag);
	}
	
	@Test
	public void deleteArticleTagTest() {
		service.deleteArticleTag(1L);
		Mockito.verify(repo).deleteById(1L);
	}

	@Test
	public void getArticleTagsTest() {
		Mockito.when(repo.findAll()).thenReturn(testTagList);
		assertTrue("Returned no tags", service.getArticleTags().size() > 0);
		Mockito.verify(repo).findAll();
	}
	
	@Test
	public void getArticleTagTest() {
		Mockito.when(repo.findTagByName("tag_name")).thenReturn(Optional.of(testTag));
		assertTrue("Returned no tags", service.getArticleTag("tag_name").getName().equals("tag_name"));
		Mockito.verify(repo).findTagByName("tag_name");
	}
	
	@Test
	public void getArticleTagIDTest() {
		Mockito.when(repo.findById(1L)).thenReturn(Optional.of(testTag));
		assertTrue("Returned no tags", service.getArticleTag(1L).getName().equals(testTag.getName()));
		Mockito.verify(repo).findById(1L);
	}
	
	@Test (expected = TagNotFoundException.class)
	public void getArticleTagExceptionTest() {		
		Mockito.when(repo.findById(100L)).thenThrow(new TagNotFoundException());
		service.getArticleTag(100L);
		Mockito.verify(repo).findById(100L);
	}


}
