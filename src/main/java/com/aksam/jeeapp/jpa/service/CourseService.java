package com.aksam.jeeapp.jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.aksam.jeeapp.jpa.bean.Course;
import com.aksam.jeeapp.jpa.servicebean.EntityManagerFactoryBean;

public class CourseService {

	
	
	private EntityManagerFactory factory;
	

	public CourseService(EntityManagerFactoryBean factoryBean) {
		
		
	factory =	factoryBean.getEntityManagerFactory();
	
	}

//	A function to get all courses from the database:
	
	public List<Course> getCourses() {
		EntityManager em = factory.createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq =
		cb.createQuery(Course.class);
		TypedQuery<Course> tq = em.createQuery(cq);
		List<Course> courses = tq.getResultList();
		em.close();
		return courses;
	}
	
	
	//A method to insert a course in the database:
	
	
	public void addCourse (Course course) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(course);
		txn.commit();
		}
	
	
	//A method to update a course in the database:
	
	public void updateCourse (Course course) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.merge(course);
		txn.commit();
	}
	
	//A method to find a course in the database by id:
	public Course getCourse (int id) {
		EntityManager em = factory.createEntityManager();
		return em.find(Course.class, id);
	}
	
	
	//A method to delete a course in the database:
	public void deleteCourse (Course course) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		Course mergedCourse = em.find(Course.class, course.getId());
		em.remove(mergedCourse);
		txn.commit();
	}
	
	
	
	
	
	
	
	
	
}
