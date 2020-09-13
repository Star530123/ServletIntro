

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class HelloPageListener
 *
 */
@WebListener
public class HomePageSessionListener implements HttpSessionListener {

	private static int count =0;
	
    /**
     * Default constructor. 
     */
    public HomePageSessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	count --;
    	System.out.println("Session Destroyed------------------------------------------------------");
    	System.out.println("");
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	System.out.println("");
    	count ++;
    	System.out.println("Session created ~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
    public static int getCount() {
    	return count;
    }
	
}
