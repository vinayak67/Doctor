package com.cts.service;

import com.cts.model.CheckupRequest;

public interface RequestService {
	
	public void saveRequest(CheckupRequest theRequest);
	public  CheckupRequest getRequest(int id);
	

}
