package ua.boardshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.boardshop.entity.Color;

public interface ColorDAO extends JpaRepository<Color, Long>, JpaSpecificationExecutor<Color>{

	Color findByName(String name);
}
