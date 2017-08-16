package ua.boardshop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.boardshop.dto.filter.BasicFilter;
import ua.boardshop.entity.Deck;
import ua.boardshop.repository.DeckDAO;
import ua.boardshop.service.DeckService;
import ua.boardshop.service.specification.DeckSpecification;

@Service
public class DeckServiceImpl implements DeckService{

	@Autowired
	private DeckDAO deckDAO;
	
	@Override
	public void save(Deck form) {
		deckDAO.save(form);
	}

	@Override
	public List<Deck> findAll() {
		return deckDAO.findAll();
	}

	@Override
	public Deck findOne(Long id) {
		return deckDAO.findOne(id);
	}

	@Override
	public void delete(Long id) {
		deckDAO.delete(id);
	}

	@Override
	public Deck findOne(String name) {
		return deckDAO.findByName(name);
	}

	@Override
	public Page<Deck> findAll(BasicFilter filter, Pageable pageable) {
		return deckDAO.findAll(new DeckSpecification(filter), pageable);
	}

}
