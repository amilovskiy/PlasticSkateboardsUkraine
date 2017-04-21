package ua.boardshop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.boardshop.dto.filter.BasicFilter;
import ua.boardshop.entity.Category;
import ua.boardshop.entity.Item;

public interface ItemService {

	public void save(Item category);
	List<Item> findAll();
	Item findOne(Long id);
	public void delete(Long id);
	Item findOne(String name);
	Page<Item> findAll(BasicFilter filter, Pageable pageable);
}
