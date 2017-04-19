package ua.boardshop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.boardshop.dto.filter.BasicFilter;
import ua.boardshop.entity.Category;

public interface CategoryService {

	public void save(Category form);
	List<Category> findAll();
	Category findOne(Long id);
	public void delete(Long id);
	Category findOne(String name);
	Page<Category> findAll(BasicFilter filter, Pageable pageable);
}