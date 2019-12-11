package main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import main.repository.entities.ArticleTag;

public interface ArticleTagRepository extends JpaRepository<ArticleTag, Long>{

	List<ArticleTag> findByName(String name);
}
