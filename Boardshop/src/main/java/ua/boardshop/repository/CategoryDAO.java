package ua.boardshop.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.boardshop.entity.Category;

public interface CategoryDAO extends JpaRepository<Category, Long>, JpaSpecificationExecutor<Category>{
	
	@Query("SELECT c FROM Category c LEFT JOIN FETCH c.item WHERE c.id=:id")
	Category findOne(@Param("id")Long id);

	@Query("SELECT c FROM Category c LEFT JOIN FETCH c.item")
	List<Category> findAll();
	
	Category findByName(String name);
	
	@Query(value="SELECT i FROM Category i LEFT JOIN FETCH i.item",
			countQuery="SELECT count(i.id) FROM Category i")
	Page<Category> findAll(Pageable pageable);
	
}
