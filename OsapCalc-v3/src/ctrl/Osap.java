package ctrl;

import java.io.IOException;
import java.lang.Math;
import java.text.DecimalFormat;
import java.io.Writer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Loan;

/**
 * Servlet implementation class Osap
 */
@WebServlet({ "/Osap", "/Osap/*" })
public class Osap extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	String appName;
	Double fixedInterest;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Osap() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override 
    public void init(ServletConfig config) throws ServletException { 
    	super.init(config);
    	ServletContext context = getServletContext();
    	appName = context.getInitParameter("applicationName");
    	context.setAttribute("legendname", appName);
    	fixedInterest = Double.parseDouble (this.getServletContext().getInitParameter("fixedInterest"));
    	
    	context.setAttribute("mLoan", new Loan());
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		System.out.println("Hello, Got a GET request from Osap!");
		response.setContentType("text/plain"); 
		Writer resOut = response.getWriter(); 
		
		
		HttpSession session = request.getSession();
		

		
		//Monthly Payments
		Double period = Double.parseDouble (this.getServletContext().getInitParameter("period"));
		Double interest = Double.parseDouble (this.getServletContext().getInitParameter("interest"));
		Double principal = Double.parseDouble (this.getServletContext().getInitParameter("principal"));
		Double gracePeriod = Double.parseDouble (this.getServletContext().getInitParameter("gracePeriod"));
		String grace = this.getServletContext().getInitParameter("grace");




		 String requestedPrincipal = request.getParameter("principal"); 
		 String requestedInterest = request.getParameter("interest"); 
		 String requestedPeriod = request.getParameter("period");
		 String requestedGrace = request.getParameter("grace");
		 System.out.println(requestedGrace);
		 
		 
		 
		 if(requestedPrincipal!=null) {
			 principal=Double.parseDouble(requestedPrincipal);
			 session.setAttribute("principal", requestedPrincipal);
		 }
		 if(requestedInterest!=null) {
			 interest=Double.parseDouble(requestedInterest);
			 session.setAttribute("interest", requestedInterest);

		 }
		 if(requestedPeriod!=null) {
			 period=Double.parseDouble(requestedPeriod);
			 session.setAttribute("period", requestedPeriod);

		 }
		 if(requestedGrace!=null) {
			 grace=requestedGrace;
			 session.setAttribute("graceperiod", "on");
			 
		 }
		 else if (requestedGrace==null) {
			 session.setAttribute("graceperiod", "");
		 }
		 
		 
		 Loan l=new Loan();
		 
	
		
		 if(period<0) {
			 request.setAttribute("error", "Period must be greater than 0!");
			 
		 }
		
	 
		 Double graceinterest=l.computeGraceInterest(interest, principal,period, grace);
		 if(graceinterest==-1.0) request.getSession().setAttribute("error", "Principal must be greater than 0!");
		 else if(graceinterest==-2.0) request.getSession().setAttribute("error", "Interest must be greater than 0!");
		 else if(graceinterest==-3.0) request.getSession().setAttribute("error", "Period must be greater than 0!");
		 else request.getSession().setAttribute("error", " ");

		
		 DecimalFormat df = new DecimalFormat("#.##");

		 request.getSession().setAttribute("graceInterest",df.format(graceinterest));
		
		 Double monthlyPayments = l.computePayment(interest, principal, period, grace, graceinterest);
		
		 request.getSession().setAttribute("payment", df.format(monthlyPayments));
		 l=(Loan) request.getAttribute("mLoan");
		 
		 
		 if(request.getParameter("calculate")==null || graceinterest<0) {
				String target = "/UI.jspx"; 
				request.getRequestDispatcher(target).forward(request, response);
				
				
				}
		 else {
			 String target = "/Results.jspx"; 
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
