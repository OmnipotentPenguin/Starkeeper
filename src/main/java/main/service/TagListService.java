package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.repository.TagListRepository;
import main.repository.entities.TagList;

@Service
public class TagListService {
	
	@Autowired
	private TagListRepository repo;
		
	private TagListService(TagListRepository repo) {
		this.repo = repo;
	}
	
	public TagList createTagList(TagList newTagList) {
		return repo.save(newTagList);		
	}	
	
	public TagList updateTagList(TagList tagList, Long id) {
		TagList toUpdate = repo.getOne(id);	
		return repo.save(toUpdate);		
	}
	
	public String deleteTagList(Long id) {
		repo.deleteById(id);
		return "TagList Deleted";
	}
	
	public List<TagList> getTagLists() {
		return repo.findAll();
	}
}
