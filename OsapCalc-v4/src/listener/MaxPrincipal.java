package listener;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

@WebListener
public class MaxPrincipal implements ServletRequestAttributeListener {
	double maxprincipal=0;

    @Override
    public void attributeAdded(ServletRequestAttributeEvent event) {
        handleEvent(event);
        
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent event) {
        System.out.println("attribute: " + event.getName() + " was removed with value: " + event.getValue());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent event) {
    	  handleEvent(event);
    }
    public void handleEvent(ServletRequestAttributeEvent event) {
    	 
    	
    	if(event.getName().equals("principal")) {
    		Double temp=Double.parseDouble(event.getValue().toString());
    		if(temp>maxprincipal)maxprincipal=temp;
    	}
    	
    	 event.getServletContext().setAttribute("maxprincipal", maxprincipal);
    }
}