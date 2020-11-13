

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
		
		String clientIP = request.getRemoteAddr();
		resOut.write("Client IP : " + clientIP + "\n");
		int clientPort = request.getRemotePort();
		resOut.write("Client Port : " + clientPort + "\n");
		resOut.write("This IP has been flagged!\n");
		String clientProtocol = request.getProtocol();
		resOut.write("Client Protocol : " + clientProtocol + "\n");
		String clientMethod = request.getMethod();
		resOut.write("Client Method : " + clientMethod + "\n");
		String clientQueryString = request.getQueryString();
		resOut.write("Query String : " + clientQueryString + "\n");
		String foo = request.getParameter("foo"); 
		resOut.write("Query Param foo=" + foo + "\n");
		String RequestURI = request.getRequestURI();
		resOut.write("Request URI : " + RequestURI + "\n");
		String RequestServletPath = request.getServletPath();
		resOut.write("Request Servlet Path : " + RequestServletPath + "\n");
		
		//Info from context object
		resOut.write("---- Info from context object----\n");		
		
		ServletContext context= this.getServletContext();
		String applicationName = this.getServletContext().getInitParameter("applicationName");
		String applicantName = this.getServletContext().getInitParameter("applicantName");
		Double principal = Double.parseDouble (this.getServletContext().getInitParameter("principal"));
		String contextPath=context.getContextPath(); 
		String realPath=context.getRealPath("Osap");
		
		resOut.write("Application name=" + applicationName + "\n");
		resOut.write("Context Path= " + contextPath + "\n");
		resOut.write("Real Path of Osap \nservlet=" + realPath + "\n");
		resOut.write("Applicant name=" + applicantName + "\n");
		
		//Session info
		
		resOut.write("---- Session info ----\n");
		HttpSession session = request.getSession();
		resOut.write("Application Name="+session.getAttribute("applicationName")+"\n");
		resOut.write("Applicant Name="+session.getAttribute("applicantName")+"\n");
		resOut.write("principal="+session.getAttribute("principal")+"\n");
		resOut.write("period="+session.getAttribute("period")+"\n");
		resOut.write("interest="+session.getAttribute("interest")+"\n");

		
		//Monthly Payments
		Double period = Double.parseDouble (this.getServletContext().getInitParameter("period"));
		Double interest = Double.parseDouble (this.getServletContext().getInitParameter("interest"));
		
		
		

		 String requestedPrincipal = request.getParameter("principal"); 
		 String requestedInterest = request.getParameter("interest"); 
		 String requestedPeriod = request.getParameter("period");
		 
		 if(requestedPrincipal!=null) {
			 principal=Double.parseDouble(requestedPrincipal);
		 }
		 if(requestedInterest!=null) {
			 interest=Double.parseDouble(requestedInterest);
		 }
		 if(requestedPeriod!=null) {
			 period=Double.parseDouble(requestedPeriod);
		 }
		
		resOut.write("---- Monthly Payments ----\n");
		
		resOut.write("Based on Principal=" + principal+" Period= "+period+" Interest= "+ interest  + "\n");
		session.setAttribute("interest", interest);
		
		 if(interest>1) {
			 interest=interest/100;
		 }
		 Double monthlyPayments = ((interest/12)*principal)/(1-Math.pow(1+(interest/12), -period));
		 DecimalFormat df = new DecimalFormat("#.#");
		resOut.write("Monthly payments:" + df.format(monthlyPayments)+"\n");
		
		session.setAttribute("applicationName", applicationName);
		session.setAttribute("applicantName", applicantName);
		session.setAttribute("principal", principal);
		session.setAttribute("period", period);
		session.setAttribute("monthlyPayments", monthlyPayments);


		

		
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
