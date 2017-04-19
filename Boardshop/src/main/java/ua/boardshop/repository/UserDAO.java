package ua.boardshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.boardshop.entity.User;

public interface UserDAO extends JpaRepository<User, Long>{

	User findByEmail(String username);
	
	@Query("SELECT u FROM User u LEFT JOIN FETCH u.commodities WHERE u.id=:id")
	User findById(@Param("id")Long id);
}
