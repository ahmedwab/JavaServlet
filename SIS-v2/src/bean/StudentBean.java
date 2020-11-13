package bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="StudentBean")
@XmlAccessorType(XmlAccessType.FIELD)
public class StudentBean {
	
	@XmlElement(name="sid") 
	private String sid;
	@XmlElement(name="name") 
	private String name;
	@XmlElement(name="credit_taken") 
	private int credit_taken;
	@XmlElement(name="credit_graduate") 
	private int credit_graduate;
	
	StudentBean(){
		
	}
	public StudentBean(String ssid,String sname, int scredit_taken, int scredit_graduate){
		this.sid=ssid;
		this.name=sname;
		this.credit_taken=scredit_taken;
		this.credit_graduate=scredit_graduate;
	}

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredit_taken() {
		return this.credit_taken;
	}

	public void setCredit_taken(int credit_taken) {
		this.credit_taken = credit_taken;
	}

	public int getCredit_graduate() {
		return this.credit_graduate;
	}

	public void setCredit_graduate(int credit_graduate) {
		this.credit_graduate = credit_graduate;
	}
	

}
