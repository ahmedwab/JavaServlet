package model;

import dao.EnrollmentDAO;
import dao.StudentDAO;
import bean.StudentBean;

import java.io.StringWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamResult;

import org.json.JSONArray;
import org.json.JSONObject;

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
	
	public String export(String namePrefix, String credit_taken) throws Exception{
		int cd=Integer.parseInt(credit_taken);
		ListWrapper lw=new ListWrapper(namePrefix,cd);
		JAXBContext jc = JAXBContext.newInstance(ListWrapper.class);
		Marshaller marshaller = jc.createMarshaller(); 
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); 
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
		StringWriter sw = new StringWriter();
		sw.write("\n");
		marshaller.marshal(lw, new StreamResult(sw));
		System.out.println(sw.toString()); 
		return sw.toString();

	}
	public String jsonReport(String namePrefix, String credit_taken) throws ClassNotFoundException, SQLException {
		int cd=Integer.parseInt(credit_taken);
		ListWrapper lw=new ListWrapper(namePrefix,cd);
		JSONObject jsonObject = new JSONObject();
	    JSONArray array = new JSONArray();
	     
	     
	      
	     jsonObject.put("namePrefix:",lw.getnamePrefix());
	     jsonObject.put("creditTaken:",lw.getcredit_taken());
	     for(StudentBean s:lw.getList()) {
	    	 JSONObject temp = new JSONObject();
	    	 temp.put("sid:",s.getSid());
	    	 temp.put("name:",s.getName());
	    	 temp.put("Credits Taken:",s.getCredit_taken());
	    	 temp.put("Credits to graduate:",s.getCredit_graduate());
	    	 array.put(temp);
	    	 


	    	 
	     }
	     jsonObject.put("studentList", array);
	      

	      return jsonObject.toString();
	}

	

}
