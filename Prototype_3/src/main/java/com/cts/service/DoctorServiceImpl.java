package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.dao.DoctorDAO;
import com.cts.model.CheckupRequest;
import com.cts.model.Doctor;

@Service("doctorService")
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
	DoctorDAO doctorDAO;

	@Override
	@Transactional
	public void saveDoctor(Doctor doctor) {
		
		doctorDAO.saveDoctor(doctor);
		
	}

	
	@Override
	@Transactional
	public Doctor getDoctor(String id) {
		
		Doctor doctor=doctorDAO.getDoctor(id);
		return doctor;
	}


	@Override
	@Transactional
	public List<CheckupRequest> getDoctorRequests(String id) {
		
		
		List<CheckupRequest> results = doctorDAO.getDoctorRequests(id);
		
		return results;
	}


	@Override
	@Transactional
	public List<CheckupRequest> getAcceptedRequests(String id) {
		
		List<CheckupRequest> results = doctorDAO.getAcceptedRequests(id);
		
		return results;
	}


	@Override
	@Transactional
	public List<CheckupRequest> getReports(String id) {

		List<CheckupRequest> results = doctorDAO.getReports(id);
		
		return results;


}
	
}
