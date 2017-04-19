package ua.boardshop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.boardshop.dto.filter.BasicFilter;
import ua.boardshop.entity.Producer;
import ua.boardshop.repository.ProducerDAO;
import ua.boardshop.service.FileWriter;
import ua.boardshop.service.FileWriter.Folder;
import ua.boardshop.service.ProducerService;
import ua.boardshop.service.specification.ProducerSpecification;

@Service
public class ProducerServiceImpl implements ProducerService{

	@Autowired
	private ProducerDAO producerDAO;
	
	@Autowired
	private FileWriter fileWriter;
	
	@Override
	public void save(Producer producer) {
		producer = producerDAO.saveAndFlush(producer);
		if(fileWriter.write(Folder.PRODUCER, producer.getFile(), producer.getId())){
			if (producer.getVersion()==null) producer.setVersion(0);
			else producer.setVersion(producer.getVersion()+1);
		}
		producerDAO.save(producer);
	}
	
	public List<Producer> findAll() {
		return producerDAO.findAll();
	}

	public Producer findOne(Long id) {
		return producerDAO.findOne(id);
	}

	public void delete(Long id) {
		producerDAO.delete(id);
	}

	public Producer findOne(String name) {
		return producerDAO.findByName(name);
	}

	@Override
	public Page<Producer> findAll(BasicFilter filter, Pageable pageable) {
		return producerDAO.findAll(new ProducerSpecification(filter), pageable);
	}
}
