package ua.boardshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.boardshop.entity.Wheel;

public interface WheelDAO extends JpaRepository<Wheel, Long>, JpaSpecificationExecutor<Wheel>{

	Wheel findByName(String name);
}
