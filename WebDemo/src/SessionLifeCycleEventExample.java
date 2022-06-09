
import javax.servlet.http.*;
import javax.servlet.*;

public class SessionLifeCycleEventExample 
	implements ServletContextListener, HttpSessionListener
{
	ServletContext servletContext;

  /* Methods from the ServletContextListener */
	public void contextInitialized(ServletContextEvent sce)
	{
		servletContext = sce.getServletContext();
		System.out.println("Context is initialized");
	}

	public void contextDestroyed(ServletContextEvent sce)
	{
		
		System.out.println("Context is destroyed");
	}


  /* Methods for the HttpSessionListener */
	public void sessionCreated(HttpSessionEvent hse)
	{
      log("CREATE",hse);
	}
  
	public void sessionDestroyed(HttpSessionEvent hse)
	{

	  HttpSession _session = hse.getSession();
      System.out.println(_session.getId());
      System.out.println(1);
      System.out.println("aaa");
	  long _start = _session.getCreationTime();
      
      
	  long _end = _session.getLastAccessedTime();
	  String _counter = (String)_session.getAttribute("counter");
      System.out.println(1);
      System.out.println(_counter);
      System.out.println(_end - _start);
      System.out.println(2);
	  log("DESTROY, Session Duration:" + (_end - _start) + "(ms) Counter:" + _counter	, hse);
	}
	
	protected void log(String msg, HttpSessionEvent hse)
	{
		String _ID = hse.getSession().getId();
		log("SessionID:" + _ID + " 	" + msg);
	}
	
	protected void log(String msg)
	{
        System.out.println("[" + getClass().getName() + "] " + msg);
	}
	
}
	