package ua.boardshop.editor;

import java.beans.PropertyEditorSupport;

import ua.boardshop.entity.User;
import ua.boardshop.service.UserService;

public class UserEditor extends PropertyEditorSupport{

	private final UserService userService;

	public UserEditor(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		User user= userService.findOne(Long.valueOf(text));
		setValue(user);
	}
}
