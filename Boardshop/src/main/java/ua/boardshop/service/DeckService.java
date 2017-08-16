package ua.boardshop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.boardshop.dto.filter.BasicFilter;
import ua.boardshop.entity.Deck;

public interface DeckService {

	public void save(Deck deck);
	List<Deck> findAll();
	Deck findOne(Long id);
	public void delete(Long id);
	Deck findOne(String name);
	Page<Deck> findAll(BasicFilter filter, Pageable pageable);
}
