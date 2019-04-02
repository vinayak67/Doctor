package com.cts.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.model.Doctor;
import com.cts.model.MedicalServices;

@Repository("medicalServiceDAO")
public class MedicalServiceDAOImpl implements MedicalServiceDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<MedicalServices> listAllServices() {
		
		Session session=sessionFactory.getCurrentSession();
		CriteriaBuilder cb=session.getCriteriaBuilder();
		CriteriaQuery<MedicalServices> cq=cb.createQuery(MedicalServices.class);
		Root<MedicalServices> root =cq.from(MedicalServices.class);
		cq.select(root);
		Query query =session.createQuery(cq);
		return query.getResultList();
	}
	
	@Override
	public void saveMedicalService(MedicalServices medicalservice) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(medicalservice);
		
	}
	
	@Override
	public MedicalServices getService(int id) {
		Session session=sessionFactory.getCurrentSession();
		MedicalServices theService =session.get(MedicalServices.class,id);
		return theService;
		
	}
	
	

}
