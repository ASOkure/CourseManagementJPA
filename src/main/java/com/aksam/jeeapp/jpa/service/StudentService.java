package com.aksam.jeeapp.jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.aksam.jeeapp.jpa.bean.Student;
import com.aksam.jeeapp.jpa.servicebean.EntityManagerFactoryBean;

public class StudentService {

	
	private EntityManagerFactory factory;

	public StudentService (EntityManagerFactoryBean factoryBean) {
		factory = factoryBean.getEntityManagerFactory();
	}
	
	public void addStudent (Student student) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(student);
		txn.commit();
	}
	
	public List<Student> getStudents() {
		EntityManager em = factory.createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
		TypedQuery<Student> tq = em.createQuery(cq);
		List<Student> students = tq.getResultList();
		em.close();
		return students;
	}

}
