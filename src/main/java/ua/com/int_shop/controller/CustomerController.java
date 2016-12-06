package ua.com.int_shop.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ua.com.int_shop.dto.DtoUtilMapper;
import ua.com.int_shop.entity.Customer;
import ua.com.int_shop.service.CustomerService; 

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/newCustomer", method=RequestMethod.GET)
	public String newCustomer(Model model){
		
		model.addAttribute("customers", customerService.getAll());
		model.addAttribute("customer", new Customer());
		
		return "views-admin-newCustomer";
	}
	
	@RequestMapping(value="/saveCustomer", method=RequestMethod.POST)
	public String saveCustomer(@ModelAttribute Customer customer, Model model){

		try {
			customerService.save(customer);
		} catch (Exception e) {
			model.addAttribute("exception", e.getMessage() + " !!!   ");
			return "views-customer-registration";
		}

		return "redirect:/home";
	}
	
	@RequestMapping(value="/deleteCustomer/{id}", method=RequestMethod.GET)
	public String deleteCustomer(@PathVariable String id){
		
		customerService.delete(Integer.parseInt(id));
		
		return "redirect:/newCustomer";
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public String registration(Model model){
		
		model.addAttribute("customers", DtoUtilMapper.customerToCustomerDTO(customerService.getAll()));
		model.addAttribute("customer", new Customer());
		
		return "views-customer-registration";
	}

//	@RequestMapping(value="/saveCustomerOfReg", method=RequestMethod.POST)
//	public String saveCustomerOfReg(@ModelAttribute Customer customer, Model model){
//
//		try {
//			customerService.save(customer);
//		} catch (Exception e) {
//			model.addAttribute("exception", e.getMessage() + " !!!   ");
//			return "views-customer-registration";
//		}
//
//		return "redirect:/home";
//	}
	
	@RequestMapping(value="/saveImage", method=RequestMethod.POST)
	public String saveImage(Principal principal, @RequestParam MultipartFile image){
		
		customerService.saveImage(principal, image);
		return "redirect:/saveCustomer";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(Model model) {

		model.addAttribute("customer",customerService.getAll());

		return "views-customer-profile";
	}
}
