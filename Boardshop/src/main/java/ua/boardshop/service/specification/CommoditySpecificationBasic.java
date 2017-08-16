package ua.boardshop.service.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.boardshop.dto.filter.BasicFilter;
import ua.boardshop.entity.Commodity;

public class CommoditySpecificationBasic  implements Specification<Commodity> {

	private final BasicFilter filter;

	public CommoditySpecificationBasic(BasicFilter filter) {
		this.filter = filter;
	}
	
	@Override
	public Predicate toPredicate(Root<Commodity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		fetch(root, query);
		if(filter.getSearch().isEmpty()) return null;
		return cb.like(root.get("name"), filter.getSearch()+"%");
	}
	
	private void fetch(Root<Commodity> root, CriteriaQuery<?> query){
		if(!query.getResultType().equals(Long.class)){
			root.fetch("category");
			root.fetch("producer");
		}
}

}
