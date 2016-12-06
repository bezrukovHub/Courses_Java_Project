package ua.com.int_shop.service;

import java.security.Principal;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ua.com.int_shop.entity.Customer;

public interface CustomerService {

	void save(Customer customer) throws Exception;
	List<Customer> getAll();
	Customer getOne(int id);
	void delete(int id);
	
	Customer findByLogin(String login);
	
	void saveImage(Principal principal,MultipartFile multipartFile);
	
}
