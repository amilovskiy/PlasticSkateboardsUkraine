package ua.boardshop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.boardshop.dto.filter.BasicFilter;
import ua.boardshop.entity.Wheel;
import ua.boardshop.repository.WheelDAO;
import ua.boardshop.service.WheelService;
import ua.boardshop.service.specification.WheelSpecification;

@Service
public class WheelServiceImpl implements WheelService {

	@Autowired
	private WheelDAO wheelDAO;
	
	@Override
	public void save(Wheel form) {
		wheelDAO.save(form);
	}

	@Override
	public List<Wheel> findAll() {
		return wheelDAO.findAll();
	}

	@Override
	public Wheel findOne(Long id) {
		return wheelDAO.findOne(id);
	}

	@Override
	public void delete(Long id) {
		wheelDAO.delete(id);
	}

	@Override
	public Wheel findOne(String name) {
		return wheelDAO.findByName(name);
	}

	@Override
	public Page<Wheel> findAll(BasicFilter filter, Pageable pageable) {
		return wheelDAO.findAll(new WheelSpecification(filter), pageable);
	}

	
}
