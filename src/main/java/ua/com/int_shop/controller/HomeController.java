package ua.com.int_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.int_shop.dto.DtoUtilMapper;
import ua.com.int_shop.service.CategoryService;
import ua.com.int_shop.service.CommodityService;
import ua.com.int_shop.service.CustomerService;
import ua.com.int_shop.service.ManufacturerService;
import ua.com.int_shop.service.Order_CService;

@Controller
public class HomeController {
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private CommodityService commodityService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ManufacturerService manufacturerService;
	@Autowired
	private Order_CService order_CService;
	
	@RequestMapping(value={"/","/home"}, method=RequestMethod.GET)
	public String home(Model model){
		
		model.addAttribute("categories", DtoUtilMapper.categoryToCategoryDTO(categoryService.getAll()));
		model.addAttribute("comodities",DtoUtilMapper.commodityToCommodityDTO(commodityService.getAll()));
		model.addAttribute("customers", DtoUtilMapper.customerToCustomerDTO(customerService.getAll()));
		model.addAttribute("manufacturers", DtoUtilMapper.manufacturerToManufacturerDTO(manufacturerService.getAll()));
		model.addAttribute("order_Cs", DtoUtilMapper.order_CToOrder_CDTO(order_CService.getAll()));
		
		return "views-base-home";
	}

	@RequestMapping(value="/addCommoditiesForManufactuer", method=RequestMethod.GET)
	public String home(@RequestParam String idManufacturer,@RequestParam String [] idCommodities){
		
		manufacturerService.addCommoditiesForManufactuer(Integer.parseInt(idManufacturer), idCommodities);
		
		return "redirect:/home";
	}

	@RequestMapping(value="/home", method=RequestMethod.POST)
	public String loginprocesing(){
		return "redirect:/home";
	}
	
	@RequestMapping("/login")
	public String login(){
		return "views-base-login";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.POST)
	public String logout(){
		return "redirect:/";
	}
	
}
