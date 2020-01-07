package main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import main.repository.entities.ArticleTag;

public interface ArticleTagRepository extends JpaRepository<ArticleTag, Long>{
	
	boolean existsTagByName(String name);

	Optional<ArticleTag> findTagByName(String name);
}
