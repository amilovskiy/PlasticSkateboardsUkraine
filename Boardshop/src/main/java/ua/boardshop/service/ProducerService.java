package ua.boardshop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.boardshop.dto.filter.BasicFilter;
import ua.boardshop.entity.Producer;

public interface ProducerService {

	public void save(Producer producer);
	List<Producer> findAll();
	Producer findOne(Long id);
	public void delete(Long id);
	Producer findOne(String name);
	Page<Producer> findAll(BasicFilter filter, Pageable pageable);
}
