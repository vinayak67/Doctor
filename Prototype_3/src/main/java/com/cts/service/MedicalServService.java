package com.cts.service;

import java.util.List;

import com.cts.model.MedicalServices;

public interface MedicalServService {
	
	List<MedicalServices> listAllServices();
	void  saveMedicalService(MedicalServices medicalservice);
	public MedicalServices getService(int id);

}
