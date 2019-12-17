package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.repository.entities.TagList;

public interface TagListRepository extends JpaRepository<TagList, Long>{
	
}
