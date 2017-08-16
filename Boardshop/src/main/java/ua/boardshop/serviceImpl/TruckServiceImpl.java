package ua.boardshop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.boardshop.dto.filter.BasicFilter;
import ua.boardshop.entity.Truck;
import ua.boardshop.repository.TruckDAO;
import ua.boardshop.service.TruckService;
import ua.boardshop.service.specification.TruckSpecification;

@Service
public class TruckServiceImpl  implements TruckService {

	@Autowired
	private TruckDAO truckDAO;
	
	@Override
	public void save(Truck form) {
		truckDAO.save(form);
	}

	@Override
	public List<Truck> findAll() {
		return truckDAO.findAll();
	}

	@Override
	public Truck findOne(Long id) {
		return truckDAO.findOne(id);
	}

	@Override
	public void delete(Long id) {
		truckDAO.delete(id);		
	}

	@Override
	public Truck findOne(String name) {
		return truckDAO.findByName(name);
	}

	@Override
	public Page<Truck> findAll(BasicFilter filter, Pageable pageable) {
		return truckDAO.findAll(new TruckSpecification(filter), pageable);
	}

}
