package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.dao.DoctorDAO;
import com.cts.dao.MedicalServiceDAO;
import com.cts.model.MedicalServices;

@Service("medicalServService")
public class MedicalServServiceImpl implements  MedicalServService{
	
	@Autowired
	MedicalServiceDAO medicalDAO;
	
	@Override
	@Transactional
	public List<MedicalServices> listAllServices() {
		
		return medicalDAO.listAllServices();
	}

	@Override
	@Transactional
	public void saveMedicalService(MedicalServices medicalservice) {
		
		medicalDAO.saveMedicalService(medicalservice);
		
	}

	@Override
	@Transactional
	public MedicalServices getService(int id) {
		
		MedicalServices service=medicalDAO.getService(id);
		return service;
	}



}
