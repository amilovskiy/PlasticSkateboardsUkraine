package ua.boardshop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.boardshop.dto.filter.BasicFilter;
import ua.boardshop.entity.Category;
import ua.boardshop.repository.CategoryDAO;
import ua.boardshop.service.CategoryService;
import ua.boardshop.service.specification.CategorySpecification;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDAO categoryDAO; 

	@Override
	@Transactional
	public void save(Category form) {
		categoryDAO.save(form);
	}

	public List<Category> findAll() {
		return categoryDAO.findAll();
	}
	
	public Category findOne(Long id) {
		return categoryDAO.findOne(id);
	}
	
	public void delete(Long id) {
		categoryDAO.delete(id);
	}

	public Category findOne(String name) {
		return categoryDAO.findByName(name);
	}

	@Override
	public Page<Category> findAll(BasicFilter filter, Pageable pageable) {
		return categoryDAO.findAll(new CategorySpecification(filter), pageable);
	}
	

}
