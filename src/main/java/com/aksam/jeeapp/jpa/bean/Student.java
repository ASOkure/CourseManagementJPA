package com.aksam.jeeapp.jpa.bean;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@ManagedBean (name="student")
@RequestScoped
@Entity
public class Student extends Person implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Temporal(TemporalType.DATE)
	@Column(name="enrolled_since")
	private Date enrolledsince;
	
	public Date getEnrolledsince() {
	return enrolledsince;
	}
	public void setEnrolledsince(Date enrolledsince)
	{
	this.enrolledsince = enrolledsince;
	}
	}