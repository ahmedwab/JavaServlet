package model;

import dao.EnrollmentDAO;
import dao.StudentDAO;
import bean.StudentBean;

import java.util.Map;

import bean.EnrollmentBean;


public class SIS {
	
	public StudentDAO sd;
	public EnrollmentDAO ed;
	
	public SIS() throws ClassNotFoundException {
		sd = new StudentDAO();
	}
	
	
	public Map<String, StudentBean> retrieveStudent(String namePrefix, String credit_taken) throws Exception{
		int cd=Integer.parseInt(credit_taken);
		return sd.retrieve(namePrefix, cd);
		
	}
	
	
	//not needed for lab 6
	public Map<String, EnrollmentBean> retrieveEnrollment() throws Exception{
		return null;
		
	}

}
