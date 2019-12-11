package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.ArticleRepository;

@Service
public class ArticleService {
	
	private ArticleRepository repo;
	
	@Autowired
	private ArticleService(ArticleRepository repo) {
		this.repo = repo;
	}

}
