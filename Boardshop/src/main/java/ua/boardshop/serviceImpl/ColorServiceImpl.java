package ua.boardshop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.boardshop.dto.filter.BasicFilter;
import ua.boardshop.entity.Color;
import ua.boardshop.entity.Deck;
import ua.boardshop.repository.ColorDAO;
import ua.boardshop.service.ColorService;
import ua.boardshop.service.DeckService;
import ua.boardshop.service.specification.ColorSpecification;
import ua.boardshop.service.specification.ProducerSpecification;

@Service
public class ColorServiceImpl implements ColorService {

	@Autowired
	private ColorDAO colorDAO;
	
	@Override
	public void save(Color form) {
		colorDAO.save(form);
	}

	@Override
	public List<Color> findAll() {
		return colorDAO.findAll();
	}

	@Override
	public Color findOne(Long id) {
		return colorDAO.findOne(id);
	}

	@Override
	public void delete(Long id) {
		colorDAO.delete(id);
	}

	@Override
	public Color findOne(String name) {
		return colorDAO.findByName(name);
	}

	@Override
	public Page<Color> findAll(BasicFilter filter, Pageable pageable) {
		return colorDAO.findAll(new ColorSpecification(filter), pageable);
	}

}
