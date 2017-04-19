package ua.boardshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.boardshop.entity.Item;

public interface ItemDAO extends JpaRepository<Item, Long>, JpaSpecificationExecutor<Item>{

	Item findByName(String name);

}
