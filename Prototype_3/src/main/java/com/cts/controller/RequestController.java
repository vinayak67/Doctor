package com.cts.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
import com.cts.service.RequestService;

@Controller
@RequestMapping("/request")
public class RequestController {
	
	@Autowired
	RequestService requestService;
	
	@GetMapping("/acceptRequest")
	public String acceptRequest(@RequestParam("id") int Id,Model theModel)
	{
		CheckupRequest theRequest=requestService.getRequest(Id);
		theRequest.setStatus("Accepted");
		requestService.saveRequest(theRequest);
		return "viewDoctorRequests";
	}
	
	@GetMapping("/declineRequest")
	public String deniedRequest(@RequestParam("id") int Id,Model theModel)
	{
		CheckupRequest theRequest=requestService.getRequest(Id);
		theRequest.setStatus("Denied");
		requestService.saveRequest(theRequest);
		return "temp";
	}
	
	@GetMapping("/updateResult")
	public String showDoctorUpdateForm(@RequestParam("id") int Id , Model model)
	{
		
	    CheckupRequest theResult=requestService.getRequest(Id);
		model.addAttribute("result",theResult);
		return "testResultUpdate";
	}
	
	@PostMapping("/saveResult")
	public String saveTestResults(@ModelAttribute("result") CheckupRequest theResult)
	{
		theResult.setStatus("Finished");
		requestService.saveRequest(theResult);
		return "doctorHome";
	}

	}
	
	

