package ua.com.int_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.int_shop.dto.DtoUtilMapper;
import ua.com.int_shop.editor.ManufacturerEditor;
import ua.com.int_shop.entity.Commodity;
import ua.com.int_shop.entity.Manufacturer;
import ua.com.int_shop.service.CommodityService;
import ua.com.int_shop.service.ManufacturerService;

@Controller
public class CommodityController {

	@Autowired
	private CommodityService commodityService;
	
	@Autowired
	private ManufacturerService manufacturerService;
	
	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Manufacturer.class, new ManufacturerEditor(manufacturerService));
	}
	
	@RequestMapping(value="/newCommodity", method=RequestMethod.GET)
	public String newCommodity(Model model){
		
		model.addAttribute("commodities", commodityService.getAll());
		model.addAttribute("commodity", new Commodity());
		model.addAttribute("manufacturerDTOs", DtoUtilMapper.manufacturerToManufacturerDTO(manufacturerService.getAll()));
		
		return "views-admin-newCommodity";
	}
	
	@RequestMapping(value="/saveCommodity", method=RequestMethod.POST)
	public String saveCommmodity(@ModelAttribute Commodity commodity){
		
		commodityService.save(commodity);
		
		return "redirect:/newCommodity";
	}
	
	@RequestMapping(value="/deleteCommodity/{id}", method=RequestMethod.GET)
	public String deleteCommmodity(@PathVariable String id){
		
		commodityService.delete(Integer.parseInt(id));
		
		return "redirect:/newCommodity";
	}
	
}
