package main.repository.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class ArticleTag {
	
	@Id
	@JoinColumn
	@GeneratedValue
	private long id;
	
	@Column(name = "tag_name", unique = true)
	private String name;
	
	@ManyToMany(mappedBy = "articleTags")
	private List<Article> articles;
	
	public ArticleTag() {
	}
	
	public ArticleTag(String name) {
		this.name = name;	
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
