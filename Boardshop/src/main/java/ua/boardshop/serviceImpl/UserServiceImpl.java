package ua.boardshop.serviceImpl;

import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.boardshop.entity.Commodity;
import ua.boardshop.entity.Role;
import ua.boardshop.entity.User;
import ua.boardshop.repository.CommodityDAO;
import ua.boardshop.repository.UserDAO;
import ua.boardshop.service.UserService;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService{
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private CommodityDAO commodityDAO;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userDAO.findByEmail(username);
	}
	
	@Override
	public void save(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		user.setRole(Role.ROLE_USER);
		userDAO.save(user);
		
	}
	
	@PostConstruct
	public void addAdmin(){
		User user = userDAO.findByEmail("admin");
		if(user==null){
			user = new User();
			user.setEmail("admin");
			user.setPassword(encoder.encode("admin"));
			user.setRole(Role.ROLE_ADMIN);
			userDAO.save(user);
		}
	}

	@Override
	public User findOne(String name) {
		return userDAO.findByEmail(name);
	}

	@Override
	public User findOne(Long id) {
		return userDAO.findById(id);
	}

	@Override
	@Transactional
	public User order(Long id, Long idUser) {
		
		User user = userDAO.findById(idUser);
		List<Commodity> commodities= user.getCommodities();
		Commodity c = commodityDAO.findOne(id);
		
		if (!commodities.contains(c)) {
			c.setCount(1);
			commodities.add(c);
		} else {
			commodities.remove(c);
			c.setCount(c.getCount() + 1);
			commodities.add(c);
		}
		
		user.setCommodities(commodities);
	
		userDAO.save(user);
		return user;
	}
	
	@Override
	public List<User> findAll() {
		return userDAO.findAll();
	}
	
	 public User getCurrentUser() throws UsernameNotFoundException {
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        Object obj = auth.getPrincipal();
	        String username = "";
	        if (obj instanceof UserDetails) {
	            username = ((UserDetails) obj).getUsername();
	        } else {
	            username = obj.toString();
	        }
	        User user = userDAO.findByEmail(username);
	        return user;
	    }

	@Override
	public void sendMail(String content, String email, String mailBody) {
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.port", "465");
		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		properties.setProperty("mail.smtp.socketFactory.port", "465");
		properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("alexmilovskiy@gmail.com","orion033");
			}
		});
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("alexmilovskiy@gmail.com"));
			message.addRecipient(Message.RecipientType. TO , new InternetAddress(email));
			message.setSubject(content, "UTF-8");
			message.setText(mailBody);
			Transport.send(message);
		} catch (MessagingException е) {
			е.printStackTrace();
		}
	}

	@Override
	public String findAm(Long id) {
		
		User user = userDAO.findById(id);
		List<Commodity> list = user.getCommodities();
		Integer amount = list.size();
		String str = new String(amount.toString());
		return str;
	}

	@Override
	public String confirmBody(Long userId) {
		User user = userDAO.findById(userId);
		List<Commodity> list = user.getCommodities();
		String body = "ORDER :" + "\n";
		float price = 0f;
		for (Commodity c : list) {
			price += c.getPrice().floatValue() * c.getCount().floatValue();
			body += "	" + c.getName() + "  -  " + c.getPrice() + "$ " + " x " + c.getCount() + " = " + 
					c.getPrice().floatValue() * c.getCount().floatValue() + "$" + "\n";
		}
		body += "\n" + "TOTAL PRICE :" + "\n" + "	" + String.format("%.2f", price) + "$" + "\n\n" + "Thank you for shopping!!!";
		return body;
	}

	@Override
	public boolean commodityListIsEmpty(Long id) {
		User user = userDAO.findById(id);
		List<Commodity> list = user.getCommodities();
		return list.isEmpty();
	}
	
}
