

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class HelloPageListener
 *
 */
@WebListener
public class HomePageRequestListener implements ServletRequestListener {

	private int count =0;
	
    /**
     * Default constructor. 
     */
    public HomePageRequestListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre)  { 
    	System.out.println("BYE");
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  { 
    	System.out.println("Welcome");
    	synchronized (this) {
    		++this.count;
		}
    	System.out.println("You are the " + count + " vistor!");
    }
	
}
