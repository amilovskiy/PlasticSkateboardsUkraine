package ua.boardshop.service.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.boardshop.dto.filter.CategoryAdminFilter;
import ua.boardshop.entity.Category;

public class CategorySpecificationAdmin  implements Specification<Category> {

	private final CategoryAdminFilter filter;

	private final List<Predicate> predicates = new ArrayList<>();
	
	private final static Pattern PATTERN = Pattern.compile("^([0-9]{1,17}\\.[0-9]{1,2})|([0-9]{1,17}\\,[0-9]{1,2})|([0-9]{1,17})$");
	
	public CategorySpecificationAdmin(CategoryAdminFilter filter) {
		this.filter = filter;
	}
	
	private void filterByName(Root<Category> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getSearch().isEmpty()){
			predicates.add(root.get("name").in(filter.getSearch()));
		}
	}
	
	private void filterByItem(Root<Category> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getItemIds().isEmpty()){
			predicates.add(root.get("item").in(filter.getItemIds()));
		}
	}
	
	private void fetch(Root<Category> root, CriteriaQuery<?> query){
		if(!query.getResultType().equals(Long.class)){
			query.distinct(true);
			root.fetch("item");
		}
	}
	
	@Override
	public Predicate toPredicate(Root<Category> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		fetch(root, query);
		filterByName(root, query, cb);
		filterByItem(root, query, cb);
		if(predicates.isEmpty())return null;
		Predicate[] array = new Predicate[predicates.size()];
		array = predicates.toArray(array);
		return cb.and(array);
	}
}
