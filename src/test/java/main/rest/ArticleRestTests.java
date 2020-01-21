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

import main.repository.ArticleRepository;
import main.repository.entities.Article;
import main.repository.entities.ArticleTag;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ArticleRestTests {

	@Autowired
	private MockMvc mock;

	@Autowired
	private ArticleRepository repo;

	private ObjectMapper mapper = new ObjectMapper();

	private long id;

	private Article testArticle;

	private Article testArticleWithID;
	
	private List<ArticleTag> testTagList;
	
	@Before
	public void init() {
		this.repo.deleteAll();
		
		this.testTagList = new ArrayList<ArticleTag>();

		this.testArticle = new Article("Fusion", "www.url.com", testTagList);
		this.testArticleWithID = this.repo.save(this.testArticle);
		this.id = this.testArticleWithID.getId();
	}

	@Test
	public void testCreateArticle() throws Exception {
		String result = this.mock
				.perform(request(HttpMethod.POST, "/createArticle").contentType(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(testArticle)).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		
		assertEquals(this.mapper.writeValueAsString(testArticleWithID), result);
	}

	@Test
	public void testDeleteArticle() throws Exception {
		this.mock.perform(request(HttpMethod.DELETE, "/deleteArticle/" + this.id)).andExpect(status().isOk());
	}

	@Test
	public void testGetAllArticles() throws Exception {
		List<Article> articleList = new ArrayList<>();
		articleList.add(this.testArticleWithID);

		String content = this.mock.perform(request(HttpMethod.GET, "/getArticles").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		assertEquals(this.mapper.writeValueAsString(articleList), content);
	}
	
	@Test
	public void testGetArticle() throws Exception {
		String content = this.mock.perform(request(HttpMethod.GET, "/getArticle/"+this.id))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		
		assertEquals(this.mapper.writeValueAsString(testArticleWithID), content);
	}

	@Test
	public void testUpdateArticle() throws Exception {
		Article newArticle = new Article("Ducks Weekly", "www.nature.com");
		Article updatedArticle = new Article(newArticle.getName(), newArticle.getUrl());
		updatedArticle.setId(this.id);

		String result = this.mock
				.perform(request(HttpMethod.PUT, "/updateArticle/?id=" + this.id).accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(newArticle)))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		
		assertEquals(this.mapper.writeValueAsString(updatedArticle), result);
	}
	
	@Test
	public void testToggleFavourite() throws Exception {		
		testArticle.setFavourite(true);
		
		String result = this.mock
				.perform(request(HttpMethod.PATCH, "/toggleFavourite/" + this.id).accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(testArticle)))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		
		assertEquals(this.mapper.writeValueAsString(testArticle), result);
	}
}
