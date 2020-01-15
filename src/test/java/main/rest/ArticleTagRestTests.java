package main.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import main.repository.ArticleTagRepository;
import main.repository.entities.ArticleTag;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ArticleTagRestTests {

	@Autowired
	private MockMvc mock;

	@Autowired
	private ArticleTagRepository repo;

	private ObjectMapper mapper = new ObjectMapper();

	private long id;

	private ArticleTag testArticleTag;

	private ArticleTag testArticleTagWithID;

	@Before
	public void init() {
		this.repo.deleteAll();
		this.testArticleTag = new ArticleTag("Fusion");
		this.testArticleTagWithID = this.repo.save(this.testArticleTag);
		this.id = this.testArticleTagWithID.getId();
	}

	@Test
	public void testCreateArticleTag() throws Exception {
		String result = this.mock
				.perform(request(HttpMethod.POST, "/createTag").contentType(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(testArticleTag)).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		
		assertEquals(this.mapper.writeValueAsString(testArticleTagWithID), result);
	}

	@Test
	public void testDeleteArticleTag() throws Exception {
		this.mock.perform(request(HttpMethod.DELETE, "/deleteTag/" + this.id)).andExpect(status().isOk());
	}

	@Test
	public void testGetAllArticles() throws Exception {
		List<ArticleTag> articleTagList = new ArrayList<>();
		articleTagList.add(this.testArticleTagWithID);

		String content = this.mock.perform(request(HttpMethod.GET, "/getTags").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		assertEquals(this.mapper.writeValueAsString(articleTagList), content);
		
		
		//Returning tagArray as null, expecting tag array as []
	}

	@Test
	public void testUpdateArticle() throws Exception {
		ArticleTag newArticleTag = new ArticleTag("Ducks");
		ArticleTag updatedTag = new ArticleTag(newArticleTag.getName());
		updatedTag.setId(this.id);
		
		String result = this.mock
				.perform(request(HttpMethod.PUT, "/updateTag/?id=" + this.id).accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(newArticleTag)))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		
		assertEquals(this.mapper.writeValueAsString(updatedTag), result);
		
		//Returning tagArray as null, expecting tag array as []
	}

}
