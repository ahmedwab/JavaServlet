package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bean.StudentBean;

public class StudentDAO{
	
	private DataSource ds;

public StudentDAO() throws ClassNotFoundException {
	try {
		 ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/EECS"); 
		} catch (NamingException e) {
						e.printStackTrace();
		}	 
	}



public Map<String, StudentBean> retrieve(String namePrefix, int credit_taken) throws SQLException{
	String query = "select * from students where surname like '%" + namePrefix +"%'and credit_taken >= " + credit_taken;
	Map<String, StudentBean> rv = new HashMap<String, StudentBean>();
	Connection con = this.ds.getConnection(); 
	PreparedStatement p = con.prepareStatement(query); 
	ResultSet r = p.executeQuery();
	while (r.next()){
			String name = r.getString("GIVENNAME") + ", " + r.getString("SURNAME"); 
			int ct=Integer.parseInt(r.getString("CREDIT_TAKEN"));
			int cg=Integer.parseInt(r.getString("CREDIT_GRADUATE"));
			StudentBean temp=new StudentBean(r.getString("SID"),name,ct,cg);
			rv.put(name,temp);
		}
	r.close(); p.close(); con.close();
	return rv;
 	}

}

