package ua.boardshop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.boardshop.dto.filter.BasicFilter;
import ua.boardshop.entity.Wheel;

public interface WheelService {

	public void save(Wheel wheel);
	List<Wheel> findAll();
	Wheel findOne(Long id);
	public void delete(Long id);
	Wheel findOne(String name);
	Page<Wheel> findAll(BasicFilter filter, Pageable pageable);
}
