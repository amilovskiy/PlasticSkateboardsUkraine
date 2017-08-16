package ua.boardshop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.boardshop.dto.filter.BasicFilter;
import ua.boardshop.entity.Color;

public interface ColorService {

	public void save(Color color);
	List<Color> findAll();
	Color findOne(Long id);
	public void delete(Long id);
	Color findOne(String name);
	Page<Color> findAll(BasicFilter filter, Pageable pageable);
}
