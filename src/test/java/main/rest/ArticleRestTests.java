package main.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import main.repository.entities.Article;
import main.rest.ArticleController;
import main.service.ArticleService;

@RunWith(SpringRunner.class)
@WebMvcTest(ArticleController.class)
@AutoConfigureMockMvc
public class ArticleRestTests {
	
	@Autowired
	private MockMvc mock;
	
	@MockBean
	private ArticleService service;	

	private ObjectMapper mapper = new ObjectMapper();	
	
	@Test
	public void createArticleTest() throws JsonProcessingException, Exception {
		
		Article testArticle = new Article("article_name", "www.url.com");
		Mockito.when(service.createArticle(testArticle)).thenReturn(testArticle);		
		
		this.mock.perform(
				request(HttpMethod.POST, "/createArticle")
				.contentType(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(testArticle))
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());	
	}
	
	@Test
	public void updateArticleTest() throws JsonProcessingException, Exception {
		
		Article testArticle = new Article("article_name", "www.url.com");
		Mockito.when(service.updateArticle(testArticle, 1L)).thenReturn(testArticle);
		
		this.mock.perform(
				request(HttpMethod.PUT, "/updateArticle")
				.contentType(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(testArticle))
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	public void getArticleTest() throws JsonProcessingException, Exception {
		
		List<Article> testArticles = new ArrayList<Article>();
		Mockito.when(service.getArticles()).thenReturn(testArticles);
		
		this.mock.perform(
				request(HttpMethod.PUT, "/updateArticle")
				.contentType(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(testArticles))
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	public void deleteArticleTest() throws JsonProcessingException, Exception {		
		
		Mockito.when(service.deleteArticle(1L)).thenReturn("Article Deleted");
		
		this.mock.perform(
				request(HttpMethod.PUT, "/updateArticle")
				.contentType(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString("Article Deleted"))
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}
