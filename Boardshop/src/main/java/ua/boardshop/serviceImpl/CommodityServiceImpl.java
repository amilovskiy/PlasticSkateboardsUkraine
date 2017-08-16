package ua.boardshop.serviceImpl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.digester.plugins.strategies.FinderSetProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.boardshop.dto.filter.BasicFilter;
import ua.boardshop.dto.filter.ShopFilter;
import ua.boardshop.dto.form.CommodityForm;
import ua.boardshop.entity.Commodity;
import ua.boardshop.entity.User;
import ua.boardshop.repository.CommodityDAO;
import ua.boardshop.repository.UserDAO;
import ua.boardshop.service.CommodityService;
import ua.boardshop.service.FileWriter;
import ua.boardshop.service.FileWriter.Folder;
import ua.boardshop.service.specification.CommoditySpecification;
import ua.boardshop.service.specification.CommoditySpecificationBasic;

@Service
public class CommodityServiceImpl implements CommodityService{

	@Autowired
	private CommodityDAO commodityDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private FileWriter fileWriter;
	
	public List<Commodity> findAll() {
		return commodityDAO.findAll();
	}

	public Commodity findOne(Long id) {
		return commodityDAO.findOne(id);
	}

	public void delete(Long id) {
		commodityDAO.delete(id);
	}

	public Commodity findOne(String name) {
		return commodityDAO.findByName(name);
	}

	@Override
	public Page<Commodity> findAll(ShopFilter filter, Pageable pageable) {
		return commodityDAO.findAll(new CommoditySpecification(filter),pageable);
	}

	@Override
	public Page<Commodity> findAll(BasicFilter filter, Pageable pageable) {
		return commodityDAO.findAll(new CommoditySpecificationBasic(filter),pageable);
	}
	
	@Override
	@Transactional
	public void save(CommodityForm form) {
		Commodity commodity = new Commodity();
		commodity.setId(form.getId());
		commodity.setName(form.getName());
		commodity.setPrice(new BigDecimal(form.getPrice().replace(',', '.')));
		commodity.setDescription(form.getDescription());
		commodity.setCategory(form.getCategory());
		commodity.setProducer(form.getProducer());
		commodity.setColor(form.getColor());
		commodity.setWheel(form.getWheel());
		commodity.setTruck(form.getTruck());
		commodity.setDeck(form.getDeck());
		commodity = commodityDAO.saveAndFlush(commodity);
		if(fileWriter.write(Folder.COMMODITY, form.getFile(), commodity.getId())){
			if (commodity.getVersion()==null) commodity.setVersion(0);
			else commodity.setVersion(commodity.getVersion()+1);
		}
		commodityDAO.save(commodity);
	}
	
	@Override
	public CommodityForm findForm(Long id) {
		Commodity commodity= findOne(id);
		CommodityForm form = new CommodityForm();
		form.setId(commodity.getId());
		form.setName(commodity.getName());
		form.setPrice(String.valueOf(commodity.getPrice()));
		form.setCount(String.valueOf(commodity.getCount()));
		form.setDescription(commodity.getDescription());
		form.setProducer(commodity.getProducer());
		form.setCategory(commodity.getCategory());
		form.setColor(commodity.getColor());
		form.setWheel(commodity.getWheel());
		form.setTruck(commodity.getTruck());
		form.setDeck(commodity.getDeck());
		return form;
	}

	@Override
	public List<Commodity> findAll(Long id) {
		return commodityDAO.findAll(id);
	}

	@Override
	public List<Commodity> findList(Long id) {
		User user = userDAO.findById(id);
		List<Commodity> commodities = user.getCommodities();
		return commodities;
	}

	@Override
	public void findListAndDelete(Long id) {
		User user = userDAO.findById(id);
		List<Commodity> commodities = user.getCommodities();
		commodities.clear();
		userDAO.save(user);
	}

	@Override
	public String findTotalPrice(Long id) {
		BigDecimal priceB;
		float price = 0;
		List<Commodity> commodities = findList(id);
		for (Commodity commodity : commodities) {
			int a = commodity.getPrice().intValue() * commodity.getCount().intValue();
			BigDecimal co = new BigDecimal(a);
			priceB = co;
			price += priceB.floatValue();
		}
		String format = String.format("%.2f", price);
		return format;
	}

	@Override
	public void findAndDelete(Long id, Commodity commodity) {
		User user = userDAO.findById(id);
		List<Commodity> commodities = user.getCommodities();
		commodities.remove(commodity);
		userDAO.save(user);
	}

}
