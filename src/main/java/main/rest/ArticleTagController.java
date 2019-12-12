package main.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import main.repository.entities.ArticleTag;
import main.service.ArticleTagService;

@RestController
public class ArticleTagController {
	
	@Autowired
	private ArticleTagService service;

	public ArticleTagController(ArticleTagService service) {
		this.service = service;
	}
	
	@GetMapping("/getTag")
	public List<ArticleTag> getArticles(){
		return service.getArticleTags();		
	}
	
	@PostMapping("/createTag")
	public ArticleTag postArticle(@RequestBody ArticleTag newTag) {
		return service.createArticleTag(newTag);
	}
	
	@PutMapping("/updateTag")
	public ArticleTag putArticle(@PathParam("id") Long id, @RequestBody ArticleTag tag) {
		return this.service.updateArticleTag(tag, id);
	}
	
	@DeleteMapping("/deleteTag/{id}")
	public void deleteArticle(@PathVariable Long id) {
		this.service.deleteArticleTag(id);		
	}
}
