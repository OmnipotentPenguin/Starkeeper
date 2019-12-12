package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.repository.entities.ArticleTag;

public interface TagListRepository extends JpaRepository<ArticleTag, Long>{
	
}
