package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.model.Doctor;
import com.cts.model.MedicalServices;
import com.cts.service.DoctorService;
import com.cts.service.MedicalServService;

@Controller
@RequestMapping("/service")
public class MedicalServiceController {
	
	@Autowired
	MedicalServService medicalService;
	
	
	@GetMapping("/listServices")
	public String getAllServices(Model model ) 
	{
		List<MedicalServices>lb=medicalService.listAllServices();
		model.addAttribute("service",lb);
		return "medicareServices";
	}
	
	@GetMapping("/view")
	public String viewService(@RequestParam("serviceId") int theId , Model model)
	{
	
		System.out.println("Hello"+theId);
		
		MedicalServices theService=medicalService.getService(theId);
		System.out.println(theService.getAmount()+"world");
		System.out.println(theService);
		
		model.addAttribute("service",theService);
		
		return "serviceDetails";
	}
	
	@PostMapping("/saveService")
	public String saveAService(@ModelAttribute("service") MedicalServices theService)
	{
		medicalService.saveMedicalService(theService);
		return "redirect:/service/listServices";
	}

	@GetMapping("/updateService")
	public String updateServiceForm(@RequestParam("serviceId") int theId , Model model)
	{
		MedicalServices theService=medicalService.getService(theId);
		model.addAttribute("service",theService);

		return "serviceUpdate";
	}


}
