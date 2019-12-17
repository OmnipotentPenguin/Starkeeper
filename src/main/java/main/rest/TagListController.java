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

import main.repository.entities.TagList;
import main.service.TagListService;

@RestController
public class TagListController {
	
	@Autowired
	private TagListService service;

	public TagListController(TagListService service) {
		this.service = service;
	}
	
	@GetMapping("/getTagList")
	public List<TagList> getTagLists(){
		return service.getTagLists();		
	}
	
	@PostMapping("/createTagList")
	public TagList postTagList(@RequestBody TagList newTagList) {
		return service.createTagList(newTagList);
	}
	
	@PutMapping("/updateTagList")
	public TagList putTagList(@PathParam("id") Long id, @RequestBody TagList tagList) {
		return this.service.updateTagList(tagList, id);
	}
	
	@DeleteMapping("/deleteTagList/{id}")
	public void deleteTagList(@PathVariable Long id) {
		this.service.deleteTagList(id);		
	}
}
