package main.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import main.repository.entities.Article;
import main.repository.entities.ArticleTag;
import main.service.ArticleService;

@RestController
public class ArticleController {
	
	@Autowired
	private ArticleService service;

	public ArticleController(ArticleService service) {
		this.service = service;
	}
	
	@GetMapping("/getArticles")
	public List<Article> getArticles(){
		return service.getArticles();		
	}
	
	@GetMapping("/getArticle/{id}")
	public Article getArticle(@PathVariable Long id){
		return service.findArticleByID(id);
	}
	
	@PostMapping("/createArticle")
	public Article postArticle(@RequestBody Article newArticle) {
		return service.createArticle(newArticle);
	}
	
	@PutMapping("/updateArticle")
	public Article putArticle(@PathParam("id") Long id, @RequestBody Article article) {
		return this.service.updateArticle(article, id);
	}
	
	@DeleteMapping("/deleteArticle/{id}")
	public void deleteArticle(@PathVariable Long id) {
		this.service.deleteArticle(id);		
	}
	
	@PatchMapping("/addTag/{id}")
	public Article addTagToArticle(@PathVariable Long id, @RequestBody ArticleTag tag) {
		return this.service.addTagToArticle(id, tag);
	}
	
	@PatchMapping("/toggleFavourite/{id}")
	public Article toggleFavouriteArticle(@PathVariable Long id) {
		return this.service.toggleFavouriteArticle(id);
	}
}
