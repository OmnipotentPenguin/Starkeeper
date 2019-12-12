package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.repository.ArticleTagRepository;
import main.repository.entities.ArticleTag;

@Service
public class ArticleTagService {
	
	@Autowired
	private ArticleTagRepository repo;
		
	private ArticleTagService(ArticleTagRepository repo) {
		this.repo = repo;
	}
	
	public ArticleTag createArticleTag(ArticleTag newTag) {
		return repo.save(newTag);		
	}	
	
	public ArticleTag updateArticleTag(ArticleTag tag, Long id) {
		ArticleTag toUpdate = repo.getOne(id);
		toUpdate.setName(tag.getName());		
		return repo.save(toUpdate);		
	}
	
	public String deleteArticleTag(Long id) {
		repo.deleteById(id);
		return "Tag Deleted";
	}
	
	public List<ArticleTag> getArticleTags() {
		return repo.findAll();
	}
}