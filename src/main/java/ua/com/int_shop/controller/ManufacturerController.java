package ua.com.int_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.int_shop.entity.Manufacturer;
import ua.com.int_shop.service.ManufacturerService; 

@Controller
public class ManufacturerController {

	@Autowired
	private ManufacturerService manufacturerService;   
	
	@RequestMapping(value="/newManufacturer", method=RequestMethod.GET)
	public String newManufacturer(Model model){
		
		model.addAttribute("manufacturers", manufacturerService.getAll());
		model.addAttribute("manufacturer", new Manufacturer());
		
		return "views-admin-newManufacturer";
	}
	
	@RequestMapping(value="/saveManufacturer", method=RequestMethod.POST)
	public String saveManufacturer(@ModelAttribute Manufacturer manufacturer){
		
		manufacturerService.save(manufacturer);
		
		return "redirect:/newManufacturer";
	}
	
	@RequestMapping(value="/deleteManufacturer/{id}", method=RequestMethod.GET)
	public String deleteManufacturer(@PathVariable String id){
		
		manufacturerService.delete(Integer.parseInt(id));
		
		return "redirect:/newManufacturer";
	}
	
	@RequestMapping(value = "/addCommoditiesForManufactuer", method = RequestMethod.POST)
	public String newManufacturer(@RequestParam String idManufacturer,
			@RequestParam String [] idCommodities)  {

		manufacturerService.addCommoditiesForManufactuer(Integer.parseInt(idManufacturer), idCommodities);
		
		return "redirect:/";
	}
	
}
