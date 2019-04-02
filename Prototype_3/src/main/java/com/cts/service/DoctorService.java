package com.cts.service;

import java.util.List;

import com.cts.model.CheckupRequest;
import com.cts.model.Doctor;
import com.cts.model.MedicalServices;


public interface DoctorService {
	
	void  saveDoctor(Doctor doctor);
	public Doctor getDoctor(String id);
	public List<CheckupRequest> getDoctorRequests(String id);
	public List<CheckupRequest> getAcceptedRequests(String id);
	public List<CheckupRequest> getReports(String id);
	
	
	

}
