package ua.com.int_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.int_shop.dto.DtoUtilMapper;
import ua.com.int_shop.entity.Order_C;
import ua.com.int_shop.service.CommodityService;
import ua.com.int_shop.service.Order_CService; 

@Controller
public class Order_CController {

	@Autowired
	private Order_CService order_CService;
	
	@Autowired
	private CommodityService commodityService;
	
	@RequestMapping(value="/newOrder_C", method=RequestMethod.GET)
	public String newOrder_C(Model model){
		
		model.addAttribute("order_CDTOs", DtoUtilMapper.order_CToOrder_CDTO(order_CService.getAll()));
		model.addAttribute("order_C", new Order_C());
		model.addAttribute("order_Cs", order_CService.getAll());
		model.addAttribute("commodities", commodityService.getAll());
		
		return "views-admin-newOrder_C";
	}
	
	@RequestMapping(value="/saveOrder_C", method=RequestMethod.POST)
	public String saveOrder_C(@ModelAttribute Order_C order_C,@RequestParam String date){
		
		
		
//		order_CService.saveOrderWithCommodities(order_C, idCommodity);
		
		//order_C.setDateofPublic(localDate);
		
		order_CService.create(order_C);
		
		return "redirect:/newOrder_C";
	}
	
	@RequestMapping(value="/deleteOrder_C/{id}", method=RequestMethod.GET)
	public String deleteOrder_C(@PathVariable String id){
		
		order_CService.delete(Integer.parseInt(id));
		
		return "redirect:/newOrder_C";
	}
}
