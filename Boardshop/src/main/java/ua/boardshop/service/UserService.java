package ua.boardshop.service;

import java.util.List;

import ua.boardshop.entity.User;

public interface UserService {

	void save(User user);
	
	User findOne(String name);
	
	User findOne(Long id);

	User order(Long id, Long idUser);

	List<User> findAll();

	User getCurrentUser();
	
	void sendMail(String content, String email, String mailBody);

	int getAmountCommodities();
//
//	int findSame(Long id, Long userId);

}
