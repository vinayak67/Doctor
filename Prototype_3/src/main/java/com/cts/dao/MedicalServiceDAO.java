package com.cts.dao;

import java.util.List;

import com.cts.model.MedicalServices;


public interface MedicalServiceDAO {
	
	List<MedicalServices> listAllServices();
	void  saveMedicalService(MedicalServices medicalservice);
	public MedicalServices getService(int id);

}
