package ua.com.int_shop.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ua.com.int_shop.dao.CustomerDao;
import ua.com.int_shop.entity.Customer;
import ua.com.int_shop.entity.Role;
import ua.com.int_shop.service.CustomerService;
import ua.com.int_shop.validation.Validator;

@Service("userDetailsService")
public class CustomerServiceImpl implements CustomerService,UserDetailsService{

	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	@Qualifier("customerValidator")
	private Validator validator;

	public void save(Customer customer) throws Exception {

		validator.validate(customer);

		customer.setRole(Role.ROLE_USER);
		customer.setPassword(encoder.encode(customer.getPassword()));
		customerDao.save(customer);
	}

	public List<Customer> getAll() {
		return customerDao.findAll();
	}

	public Customer getOne(int id) {
		return customerDao.findOne(id);
	}

	public void delete(int id) {
		customerDao.delete(id);
	}

	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		return customerDao.findByLogin(login);
	}

	public Customer findByLogin(String login) {
		return customerDao.findByLogin(login);
	}
	
	@Transactional
	public void saveImage(Principal principal, MultipartFile multipartFile) {

	    Customer user = customerDao.findOne(Integer.parseInt(principal.getName()));

	    String path = System.getProperty("catalina.home") + "/resources/"
	            + user.getName() + "/" + multipartFile.getOriginalFilename();

	    user.setPathImage("resources/" + user.getName() + "/" + multipartFile.getOriginalFilename());

	    File file = new File(path);

	    try {
	        file.mkdirs();
	        try {
	            FileUtils.cleanDirectory
	                    (new File(System.getProperty("catalina.home") + "/resources/" + user.getName() + "/"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        multipartFile.transferTo(file);
	    } catch (IOException e) {
	        System.out.println("error with file");
	    }
	    customerDao.save(user);
	}

}
