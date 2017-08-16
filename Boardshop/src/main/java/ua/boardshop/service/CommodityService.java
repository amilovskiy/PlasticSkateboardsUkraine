package ua.boardshop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.boardshop.dto.filter.BasicFilter;
import ua.boardshop.dto.filter.ShopFilter;
import ua.boardshop.dto.form.CommodityForm;
import ua.boardshop.entity.Commodity;

public interface CommodityService {

	List<Commodity> findAll();
	Commodity findOne(Long id);
	public void delete(Long id);
	Commodity findOne(String name);
	void save(CommodityForm commodity);
	CommodityForm findForm(Long id);
	Page<Commodity> findAll(ShopFilter filter,Pageable pageable);
	Page<Commodity> findAll(BasicFilter filter,Pageable pageable);
	List<Commodity> findAll(Long id);
	List<Commodity> findList(Long id);
	void findListAndDelete(Long id);
	void findAndDelete(Long id, Commodity commodity);
	String findTotalPrice(Long id);
}