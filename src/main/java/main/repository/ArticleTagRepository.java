package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.repository.entities.ArticleTag;

public interface ArticleTagRepository extends JpaRepository<ArticleTag, Long>{
	
	boolean existsTagByName(String name);
}
