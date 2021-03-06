package com.cts.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dao.RequestDAO;
import com.cts.model.CheckupRequest;

@Service("requestService")
public class RequestServiceImpl implements RequestService{

	@Autowired
	RequestDAO requestDAO;
	
	@Override
	@Transactional
	public CheckupRequest getRequest(int id) {
	
		CheckupRequest theRequest=requestDAO.getRequest(id);
		return theRequest;
	
	}

	@Override
	@Transactional
	public void saveRequest(CheckupRequest theRequest) {
		
		requestDAO.saveRequest(theRequest);
		
	}


}
