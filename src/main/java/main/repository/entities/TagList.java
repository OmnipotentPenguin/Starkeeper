package main.repository.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TagList {
	
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	@JoinColumn
	Article article;
	
	@ManyToOne
	@JoinColumn
	ArticleTag articleTag;

}
