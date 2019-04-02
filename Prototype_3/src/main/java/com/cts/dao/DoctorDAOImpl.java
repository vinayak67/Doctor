package com.cts.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.model.CheckupRequest;
import com.cts.model.Doctor;

@Repository("doctorDAO")
public class DoctorDAOImpl implements DoctorDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveDoctor(Doctor doctor) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(doctor);
		
	}


	@Override
	public Doctor getDoctor(String id) {
		Session session=sessionFactory.getCurrentSession();
		Doctor theDoctor =session.get(Doctor.class,id);
		return theDoctor;
		
	}



	@Override
	public List<CheckupRequest> getDoctorRequests(String id) {
		
		Session session=sessionFactory.getCurrentSession();
		
		CriteriaBuilder cb=session.getCriteriaBuilder();
		
		CriteriaQuery<Doctor> query = cb.createQuery(Doctor.class);
		Root<Doctor> doctor = query.from(Doctor.class);
		Join<CheckupRequest,Doctor> request=doctor.join("requests");
		query.select(request).where(cb.equal(request.get("status"), "Pending"));
		
		Query pop =session.createQuery(query);
		List<CheckupRequest> results = pop.getResultList();
		
		return results;
		
		
	}


	@Override
	public List<CheckupRequest> getAcceptedRequests(String id) {
		
		Session session=sessionFactory.getCurrentSession();
		
		CriteriaBuilder cb=session.getCriteriaBuilder();
		
		CriteriaQuery<Doctor> query = cb.createQuery(Doctor.class);
		Root<Doctor> doctor = query.from(Doctor.class);
		Join<CheckupRequest,Doctor> request=doctor.join("requests");
		query.select(request).where(cb.equal(request.get("status"), "Accepted"));
		
		Query pop =session.createQuery(query);
		List<CheckupRequest> results = pop.getResultList();
		return results;
		
	}


	@Override
	public List<CheckupRequest> getReports(String id) {
		
		Session session=sessionFactory.getCurrentSession();
		
		CriteriaBuilder cb=session.getCriteriaBuilder();
		
		CriteriaQuery<Doctor> query = cb.createQuery(Doctor.class);
		Root<Doctor> doctor = query.from(Doctor.class);
		Join<CheckupRequest,Doctor> request=doctor.join("requests");
		query.select(request).where(cb.equal(request.get("status"), "Finished"));
		
		Query pop =session.createQuery(query);
		List<CheckupRequest> results = pop.getResultList();

		return results;
	}	
	

}
