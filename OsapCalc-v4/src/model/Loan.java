package model;


public class Loan extends Exception{
	static final double fixedInterest = 0.05;
	static final double gracePeriod = 5;
	
	
	public Loan() {
		
	};

	
	 public double computePayment(Double interest, Double principal, Double period, String
		      grace,Double graceinterest) throws IllegalArgumentException{
		
		 if(interest>1) {
			 interest=interest/100;
		 }
		 Double monthlyPayments = (((interest+fixedInterest)/12)*principal)/(1-Math.pow(1+((interest+fixedInterest)/12), -period));
		 monthlyPayments+= (graceinterest/gracePeriod);
		 return monthlyPayments;
		
		
	 }
	


	public double computeGraceInterest(Double interest, Double principal, Double period,String grace ) throws IllegalArgumentException{
		
		  if (principal<0) {
			  return -1.0;
		  }
		  else if (interest<0) {
			  return -2.0;
		  }
		  else if (period<0) {
			  return -3.0;
		  }
		  
		 	if(interest>1) {
			 interest=interest/100;
		 	}
			if(grace=="off") {
				return 0.0;
			}
			else return principal*((interest+fixedInterest)/12)*gracePeriod;
	 }

}
