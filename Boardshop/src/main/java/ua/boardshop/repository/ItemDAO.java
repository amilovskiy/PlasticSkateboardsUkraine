package ua.boardshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.boardshop.entity.Category;
import ua.boardshop.entity.Item;

public interface ItemDAO extends JpaRepository<Item, Long>, JpaSpecificationExecutor<Item>{

	Item findByName(String name);

//	@Query("SELECT i FROM Item i LEFT JOIN FETCH i.categories")
	List<Item> findAll();
	
	@Query("SELECT i FROM Item i LEFT JOIN FETCH i.categories")
	List<Item> findAllCurentCategory();
}
