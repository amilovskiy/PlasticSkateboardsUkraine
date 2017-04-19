package ua.boardshop.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.boardshop.entity.User;
import ua.boardshop.service.UserService;

public class RegistrationValidator implements Validator{

	private final static Pattern REG = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	
//	private final static Pattern REG1 = Pattern.compile("^{7,20}$");
	
	private final UserService userService;

	public RegistrationValidator(UserService userService) {
		this.userService = userService;
	}

	@Override
	public boolean supports(Class<?> zingabouzer) {
		return zingabouzer.equals(User.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		if(!REG.matcher(user.getEmail()).matches()){
			errors.rejectValue("email", "", "This is not email");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "", "Can`t be empty, motherfucker!!! One more time and Samuel L. Jackson will kill you");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "", "Enter password");
		if(userService.findOne(user.getEmail())!=null){
			errors.rejectValue("email", "", "Already exist");
		}	
		if((user.getPassword().length()) < 8){
			errors.rejectValue("password", "", "Password must have at least 8 characters");
		}	
	}
}
