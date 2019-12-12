package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.repository.ArticleRepository;
import main.repository.entities.Article;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleRepository repo;
		
	private ArticleService(ArticleRepository repo) {
		this.repo = repo;
	}
	
	public Article createArticle(Article newArticle) {
		return repo.save(newArticle);		
	}	
	
	public Article updateArticle(Article article, Long id) {
		Article toUpdate = repo.getOne(id);
		toUpdate.setName(article.getName());
		toUpdate.setUrl(article.getUrl());		
		return repo.save(toUpdate);		
	}
	
	public String deleteArticle(Long id) {
		repo.deleteById(id);
		return "Article Deleted";
	}
	
	public List<Article> getArticles() {
		return repo.findAll();
	}
}
