package ua.boardshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.boardshop.entity.Deck;

public interface DeckDAO extends JpaRepository<Deck, Long>, JpaSpecificationExecutor<Deck>{

	Deck findByName(String name);
}
