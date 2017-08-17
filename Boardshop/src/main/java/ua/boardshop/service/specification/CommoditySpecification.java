package ua.boardshop.service.specification;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.boardshop.dto.filter.ShopFilter;
import ua.boardshop.entity.Commodity;

public class CommoditySpecification implements Specification<Commodity>{
	
	private final ShopFilter filter;
	
	private final List<Predicate> predicates = new ArrayList<>();
	
	private final static Pattern PATTERN = Pattern.compile("^([0-9]{1,17}\\.[0-9]{1,2})|([0-9]{1,17}\\,[0-9]{1,2})|([0-9]{1,17})$");
	
	public CommoditySpecification(ShopFilter filter) {
		this.filter = filter;
		if(PATTERN.matcher(filter.getMax()).matches()){
			filter.setMaxValue(new BigDecimal(filter.getMax().replace(',', '.')));
		}
		if(PATTERN.matcher(filter.getMin()).matches()){
			filter.setMinValue(new BigDecimal(filter.getMin().replace(',', '.')));
		}
	}
	
	private void filterByName(Root<Commodity> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getSearch().isEmpty()){
			predicates.add(root.get("name").in(filter.getSearch()));
		}
	}
	
	private void filterByColor(Root<Commodity> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getColorIds().isEmpty()){
			predicates.add(root.get("color").in(filter.getColorIds()));
		}
	}
	
	private void filterByDeck(Root<Commodity> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getDeckIds().isEmpty()){
			predicates.add(root.get("deck").in(filter.getDeckIds()));
		}
	}
	
	private void filterByWheel(Root<Commodity> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getWheelIds().isEmpty()){
			predicates.add(root.get("wheel").in(filter.getWheelIds()));
		}
	}
	
	private void filterByTruck(Root<Commodity> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getTruckIds().isEmpty()){
			predicates.add(root.get("truck").in(filter.getTruckIds()));
		}
	}
	
	private void filterByProducer(Root<Commodity> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getProducerIds().isEmpty()){
			predicates.add(root.get("producer").in(filter.getProducerIds()));
		}
	}

	private void fetch(Root<Commodity> root, CriteriaQuery<?> query){
		if(!query.getResultType().equals(Long.class)){
			query.distinct(true);
			root.fetch("producer");
			root.fetch("color");
			root.fetch("deck");
			root.fetch("wheel");
			root.fetch("truck");
		}
	}

	private void filterByPrice(Root<Commodity> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(filter.getMaxValue()!=null){
			predicates.add(cb.le(root.get("price"), filter.getMaxValue()));
		}
		if(filter.getMinValue()!=null){
			predicates.add(cb.ge(root.get("price"), filter.getMinValue()));
		}
	}
	
	@Override
	public Predicate toPredicate(Root<Commodity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		fetch(root, query);
		filterByName(root, query, cb);
		filterByProducer(root, query, cb);
		filterByColor(root, query, cb);
		filterByDeck(root, query, cb);
		filterByWheel(root, query, cb);
		filterByTruck(root, query, cb);
		filterByPrice(root, query, cb);
		if(predicates.isEmpty())return null;
		Predicate[] array = new Predicate[predicates.size()];
		array = predicates.toArray(array);
		return cb.and(array);
}
	
	
//	public CommoditySpecification(ShopFilter filter) {
//		this.filter = filter;
//	}
//	
//	@Override
//	public Predicate toPredicate(Root<Commodity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//		fetch(root, query);
//		if(filter.getSearch().isEmpty()) return null;
//		return cb.like(root.get("name"), filter.getSearch()+"%");
//	}
//	
//	private void fetch(Root<Commodity> root, CriteriaQuery<?> query){
//		if(!query.getResultType().equals(Long.class)){
//			root.fetch("category");
//			root.fetch("producer");
//		}
//	}	

}
