package ua.boardshop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.boardshop.dto.filter.BasicFilter;
import ua.boardshop.entity.Truck;

public interface TruckService {

	public void save(Truck truck);
	List<Truck> findAll();
	Truck findOne(Long id);
	public void delete(Long id);
	Truck findOne(String name);
	Page<Truck> findAll(BasicFilter filter, Pageable pageable);
}
