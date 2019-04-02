package com.cts.dao;

import java.util.List;

import com.cts.model.CheckupRequest;
import com.cts.model.Doctor;

public interface RequestDAO {
	
	public  CheckupRequest getRequest(int id);
	//List<CheckupRequest> listCustomerRequests();
	void saveRequest(CheckupRequest request);

}
