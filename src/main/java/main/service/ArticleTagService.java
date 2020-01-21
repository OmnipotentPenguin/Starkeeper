package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.exceptions.TagNotFoundException;
import main.repository.ArticleTagRepository;
import main.repository.entities.ArticleTag;

@Service
public class ArticleTagService {
	
	@Autowired
	private ArticleTagRepository repo;
	
	public ArticleTag createArticleTag(ArticleTag newTag) {
		if (repo.existsTagByName(newTag.getName())) {
			return getArticleTag(newTag.getName());			 
		}
		else {
			return repo.save(newTag);	
		}	
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
	
	public ArticleTag getArticleTag(Long id) {
		return this.repo.findById(id).orElseThrow(TagNotFoundException::new);
	}
	
	public ArticleTag getArticleTag(String name) {
		return this.repo.findTagByName(name).orElseThrow(TagNotFoundException::new);
	}
	
	public List<ArticleTag> getArticleTags() {
		return repo.findAll();
	}
}