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

import com.cts.model.CheckupRequest;
import com.cts.model.Doctor;

import com.cts.service.DoctorService;
import com.cts.service.DoctorService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	DoctorService doctorService;
	
	
	@PostMapping("/saveDoctor")
	public String saveDoctorDetails(@ModelAttribute("doctor") Doctor theDoctor)
	{
		doctorService.saveDoctor(theDoctor);
		return "redirect:/doctor/doctorhome";
	}
	

	@GetMapping("/updateDoctor")
	public String showDoctorUpdateForm(@RequestParam("doctorId") String theId , Model model)
	{
		System.out.println("ye rahi ID :"+theId);
	    Doctor theDoctor=doctorService.getDoctor(theId);
	   
		model.addAttribute("doctor",theDoctor);
		return "doctorUpdate";
	}
	

	@GetMapping("/doctorhome")
	public String showDoctor(@ModelAttribute("id") String theId , Model model)
	{
		Doctor theDoctor=doctorService.getDoctor(theId);
		model.addAttribute("doctor",theDoctor);
		return "doctorHome";
	}


	@GetMapping("/viewDoctorRequests")
	public String viewDoctorRequests(@RequestParam("id") String Id,Model theModel)
	{
		List<CheckupRequest> results = doctorService.getDoctorRequests(Id);
		theModel.addAttribute("requests",results);
		
		return "doctorRequests";
	
	}
	
	@GetMapping("/viewAcceptedRequests")
	public String viewAcceptedRequests(@RequestParam("id") String Id,Model theModel)
	{
		
		List<CheckupRequest> results = doctorService.getAcceptedRequests(Id);
		theModel.addAttribute("requests",results);
		
		
		return "acceptedRequests";
	
	}
	
	
	@GetMapping("/viewReports")
	public String viewReports(@RequestParam("id") String Id,Model theModel)
	{
		List<CheckupRequest> results = doctorService.getReports(Id);
		theModel.addAttribute("requests",results);
	
		return "doctorReports";
	
	}

}
