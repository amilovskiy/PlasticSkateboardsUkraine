package ua.boardshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.boardshop.entity.Truck;

public interface TruckDAO extends JpaRepository<Truck, Long>, JpaSpecificationExecutor<Truck>{

	Truck findByName(String name);
}
