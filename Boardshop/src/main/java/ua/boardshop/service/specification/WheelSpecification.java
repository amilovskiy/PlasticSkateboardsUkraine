package ua.boardshop.service.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.boardshop.dto.filter.BasicFilter;
import ua.boardshop.entity.Wheel;

public class WheelSpecification implements Specification<Wheel> {

	private final BasicFilter filter;

	public WheelSpecification(BasicFilter filter) {
		this.filter = filter;
	}

	@Override
	public Predicate toPredicate(Root<Wheel> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if(filter.getSearch().isEmpty()) return null;
		return cb.like(root.get("name"), filter.getSearch()+"%");
	}
}
