package ua.boardshop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.boardshop.dto.filter.BasicFilter;
import ua.boardshop.entity.Category;
import ua.boardshop.entity.Item;
import ua.boardshop.repository.ItemDAO;
import ua.boardshop.service.ItemService;
import ua.boardshop.service.specification.ItemSpecification;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemDAO itemDAO;
	
	@Override
	public void save(Item item) {
		itemDAO.save(item);
	}

	@Override
	public List<Item> findAll() {
		return itemDAO.findAll();
	}

	@Override
	public Item findOne(Long id) {
		return itemDAO.findOne(id);
	}

	@Override
	public void delete(Long id) {
		Item item = itemDAO.findOne(id);
		List<Category> list = item.getCategories();
		if (list.isEmpty())
			itemDAO.delete(id);
	}

	@Override
	public Item findOne(String name) {
		return itemDAO.findByName(name);
	}

	@Override
	public Page<Item> findAll(BasicFilter filter, Pageable pageable) {
		return itemDAO.findAll(new ItemSpecification(filter), pageable);
	}
}
