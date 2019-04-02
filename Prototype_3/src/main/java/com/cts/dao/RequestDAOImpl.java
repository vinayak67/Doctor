package com.cts.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.model.CheckupRequest;
import com.cts.model.Doctor;

@Repository("requestDAO")
public class RequestDAOImpl implements RequestDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveRequest(CheckupRequest request) {

		sessionFactory.getCurrentSession().saveOrUpdate(request);
		
	}
	
	@Override
	public CheckupRequest getRequest(int id) {
		Session session=sessionFactory.getCurrentSession();
		CheckupRequest theRequest =session.get(CheckupRequest.class,id);
		return theRequest;
	}
	

}
