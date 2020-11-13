package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import bean.StudentBean;
import dao.StudentDAO;

@XmlRootElement(name="sisReport")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListWrapper	{	

@XmlAttribute	
private String namePrefix;

@XmlAttribute
private int credit_taken;

@XmlElement(name="studentList") 
private List<StudentBean> list;



public ListWrapper() {
	
}


public ListWrapper(String name, int credit) throws SQLException, ClassNotFoundException {
	StudentDAO sd=new StudentDAO();
	this.namePrefix=name;
	this.credit_taken=credit;
	 Map<String, StudentBean> map = sd.retrieve(name, credit);
	 list=new ArrayList<StudentBean>(map.values());
	
}



public String getnamePrefix() {
	return this.namePrefix;
}
public void setnamePrefix(String namePrefix) {
	this.namePrefix=namePrefix;
}
public String getcredit_taken() {
	return this.namePrefix;
}
public void setcredit_taken(int credit_taken) {
	this.credit_taken=credit_taken;
}
public List<StudentBean> getList(){
	return list;
}
public void setList(List<StudentBean> list) {
	this.list=list;
}





}