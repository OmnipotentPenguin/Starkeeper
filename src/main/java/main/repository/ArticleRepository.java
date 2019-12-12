package main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.repository.entities.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{

	List<Article> findByName(String name);
	List<Article> findByFavourite(boolean favourite);

}
