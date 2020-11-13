

import java.io.IOException;
import java.lang.Math;
import java.text.DecimalFormat;
import java.io.Writer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Osap
 */
@WebServlet({ "/Osap", "/Osap/*" })
public class Osap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Osap() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		System.out.println("Hello, Got a GET request from Osap!");
		response.setContentType("text/plain"); 
		Writer resOut = response.getWriter(); 
		resOut.write("Hello, World!\n");
		
		
		HttpSession session = request.getSession();
		

		
		//Monthly Payments
		Double period = Double.parseDouble (this.getServletContext().getInitParameter("period"));
		Double interest = Double.parseDouble (this.getServletContext().getInitParameter("interest"));
		Double principal = Double.parseDouble (this.getServletContext().getInitParameter("principal"));
		Double fixedInterest = Double.parseDouble (this.getServletContext().getInitParameter("fixedInterest"));
		Double gracePeriod = Double.parseDouble (this.getServletContext().getInitParameter("gracePeriod"));
		String grace = this.getServletContext().getInitParameter("grace");




		 String requestedPrincipal = request.getParameter("principal"); 
		 String requestedInterest = request.getParameter("interest"); 
		 String requestedPeriod = request.getParameter("period");
		 String requestedGrace = request.getParameter("grace");
		 
		 
		 
		 if(requestedPrincipal!=null) {
			 principal=Double.parseDouble(requestedPrincipal);
		 }
		 if(requestedInterest!=null) {
			 interest=Double.parseDouble(requestedInterest);
		 }
		 if(requestedPeriod!=null) {
			 period=Double.parseDouble(requestedPeriod);
		 }
		 if(requestedGrace!=null) {
			 grace=requestedGrace;
		 }
		 
		 
		 
		resOut.write("---- Monthly Payments ----\n");
		
		resOut.write("Based on Principal=" + principal+" Period= "+period+" Interest= "+ interest  + " Grace= " +grace+ "\n");
		session.setAttribute("interest", interest);
		
		
		
		 if(interest>1) {
			 interest=interest/100;
		 }
		if(fixedInterest>1) {
			fixedInterest=fixedInterest/100;
		}
		Double graceinterest=principal*((interest+fixedInterest)/12)*gracePeriod;
		if(grace=="off") {
			graceinterest=0.0;
		}
		
		 DecimalFormat df = new DecimalFormat("#.##");

		 request.getSession().setAttribute("graceInterest",df.format(graceinterest));
		
		 Double monthlyPayments = (((interest+fixedInterest)/12)*principal)/(1-Math.pow(1+((interest+fixedInterest)/12), -period));
		 monthlyPayments+= (graceinterest/gracePeriod);
		 request.getSession().setAttribute("payment", df.format(monthlyPayments));
		 
		 
		 if(request.getParameter("calculate")==null) {
				String target = "/UI.jsp"; 
				request.getRequestDispatcher(target).forward(request, response);
				
				
				}
		 else {
			 String target = "/Results.jsp"; 
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
