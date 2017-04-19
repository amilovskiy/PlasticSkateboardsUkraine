package ua.boardshop.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.boardshop.entity.Commodity;

public interface CommodityDAO extends JpaRepository<Commodity, Long>, JpaSpecificationExecutor<Commodity>{

	@Query("SELECT c FROM Commodity c LEFT JOIN FETCH c.producer LEFT JOIN FETCH c.category WHERE c.id=:id")
	Commodity findOne(@Param("id")Long id);
	
	@Query("SELECT c FROM Commodity c LEFT JOIN FETCH c.producer LEFT JOIN FETCH c.category")
	List<Commodity> findAll();

	Commodity findByName(String name);
	
	@Query(value="SELECT i FROM Commodity i LEFT JOIN FETCH i.category LEFT JOIN FETCH i.producer",
			countQuery="SELECT count(i.id) FROM Commodity i")
	Page<Commodity> findAll(Pageable pageable);

	@Query("SELECT c FROM Commodity c LEFT JOIN FETCH c.producer LEFT JOIN FETCH c.category WHERE c.category.id=:id")
	List<Commodity> findAll(@Param("id")Long id);

}