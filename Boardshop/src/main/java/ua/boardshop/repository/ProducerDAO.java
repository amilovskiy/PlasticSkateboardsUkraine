package ua.boardshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.boardshop.entity.Producer;

public interface ProducerDAO extends JpaRepository<Producer, Long>, JpaSpecificationExecutor<Producer>{

	Producer findByName(String name);

}
