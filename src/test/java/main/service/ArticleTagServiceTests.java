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

import main.repository.entities.ArticleTag;
import main.rest.ArticleTagController;

@RunWith(SpringRunner.class)
public class ArticleTagServiceTests {

	@InjectMocks
	private ArticleTagController controller;

	@Mock
	private ArticleTagService service;

	@Test
	public void createArticleTagTest() {
		ArticleTag testArticleTag = new ArticleTag("tag_name");
		Mockito.when(service.createArticleTag(testArticleTag)).thenReturn(testArticleTag);
		assertTrue("Tag has not been created", service.createArticleTag(testArticleTag).getName().equals("tag_name"));
		Mockito.verify(service).createArticleTag(testArticleTag);
	}

	@Test
	public void updateArticleTagTest() {
		ArticleTag newArticleTag = new ArticleTag("tag_replacement");
		Mockito.when(service.updateArticleTag(newArticleTag, 1L)).thenReturn(newArticleTag);
		assertTrue("Tag has not been updated", service.updateArticleTag(newArticleTag, 1L).getName().equals("tag_replacement"));
		Mockito.verify(service).updateArticleTag(newArticleTag, 1L);
	}

	@Test
	public void deleteArticleTagTest() {
		Mockito.when(service.deleteArticleTag(1L)).thenReturn("Tag Deleted");
		assertTrue("Tag has not been deleted", service.deleteArticleTag(1L).equals("Tag Deleted"));
		Mockito.verify(service).deleteArticleTag(1L);
	}

	@Test
	public void getArticleTagsTest() {
		List<ArticleTag> articleTags = new ArrayList<ArticleTag>();
		articleTags.add(new ArticleTag("tag_name"));
		Mockito.when(service.getArticleTags()).thenReturn(articleTags);
		assertTrue("Returned no tags", service.getArticleTags().size() > 0);
		Mockito.verify(service).getArticleTags();
	}

}
