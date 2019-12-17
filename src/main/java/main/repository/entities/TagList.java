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
	
	@ManyToOne(targetEntity = Article.class)
	@JoinColumn (name = "article_id")
	Article article;
	
	@ManyToOne(targetEntity = ArticleTag.class)
	@JoinColumn (name = "articleTag_id")
	ArticleTag articleTag;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public ArticleTag getArticleTag() {
		return articleTag;
	}

	public void setArticleTag(ArticleTag articleTag) {
		this.articleTag = articleTag;
	}
	
	public TagList() {
	}

	public TagList(Article article, ArticleTag articleTag) {
		super();
		this.article = article;
		this.articleTag = articleTag;
	}
}
