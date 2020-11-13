package bean;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentBean {
	
	private String cid;
	private StudentBean students;
	private int credit;
	
	
	EnrollmentBean(){
		
	}
	
	EnrollmentBean(String cid, List<StudentBean> students, int credit){
		this.setCid(cid);
		this.students=new StudentBean();
		this.setCredit(credit);
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public StudentBean getStudents() {
		return students;
	}

	public void setStudents(StudentBean students) {
		this.students = students;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

}
