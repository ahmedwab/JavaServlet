package ctrl;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.StudentBean;

/**
 * Servlet implementation class SIS
 */
@WebServlet("/SIS")
public class SIS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SIS() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String s="";
		String size="There are 0 entries";
		
		 String name = request.getParameter("name"); 
		 String credit= request.getParameter("credit");
		 
		 
		 response.setContentType("text/plain"); 
			Writer resOut = response.getWriter(); 
		
		if(name!=null && credit!=null) {
			
		s=" <table> <tr>\n"
				+ "    <th>ID</th>\n"
				+  "    <th>Name</th>\n"
				+  "    <th>Credits taken</th>\n"
				+  "    <th>Credits to graduate</th>\n"
				+ "  </tr>";
			try {
				model.SIS sis=new model.SIS();
				size="There are "+sis.retrieveStudent(name, credit).size()+" entries\n";
				
				Iterator<Entry<String, StudentBean>> it = sis.retrieveStudent(name, credit).entrySet().iterator(); 
				 while (it.hasNext()) { 
			            @SuppressWarnings("rawtypes")
						Map.Entry mapElement = (Map.Entry)it.next(); 
			            StudentBean temp= (StudentBean)mapElement.getValue();
			            String sid=temp.getSid();
			            String sname=temp.getName();
			            int ct=temp.getCredit_taken();
			            int cg=temp.getCredit_graduate();
			      s+="<tr><td>"+sid+"</td><td>"+sname+"</td><td>"+ct+"</td><td>"+cg+"</td></tr><div>";
			        } 
				 s+="</table>";
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("size", size);
			request.setAttribute("result", s);
		
		}
		
		
		
		 	String report = request.getParameter("report"); 
		 	String generate = request.getParameter("generate"); 
		 	String json = request.getParameter("json"); 
		 	String json_ajax = request.getParameter("ajax"); 
		 	String t = "true";

		 	System.out.println(json_ajax);
		 	
		 	if(json==null) {
		 		json="false";
		 	}
		 	if(json_ajax==null) {
		 		json_ajax="false";
		 	}
		 	
		 	
		 	
		 if(generate!=null){

			try {
				model.SIS sis=new model.SIS();
				String output=sis.export(name,credit);
				resOut.write(output);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		 else if (json.equals(t)) {
			 try {
					model.SIS sis=new model.SIS();
					String output=sis.jsonReport(name, credit);
					resOut.write(output);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
		 else if (json_ajax.equals(t)) {
			 try {
					model.SIS sis=new model.SIS();
					String output=sis.jsonReport(name, credit);
					resOut.write(output);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
		
		 else  {
				
				String target = "/Form.jspx?"; 
				request.getRequestDispatcher(target).forward(request, response);
			}
		
			
			
			
			
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
