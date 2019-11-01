package com.aksam.jeeapp.jpa.servicebean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


@ManagedBean(name="emFactoryBean", eager=true)
@ApplicationScoped
public class EntityManagerFactoryBean {
	
	
	private EntityManagerFactory entityManagerFactory;

	

	public EntityManagerFactoryBean() {
		
		entityManagerFactory = Persistence.createEntityManagerFactory("CourseManagementJPA");
		
	}


	
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	
}
