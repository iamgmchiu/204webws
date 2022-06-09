

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;


/**
 * Servlet Filter implementation class LogFilter
 */
@WebFilter(
		urlPatterns = { "/*" }, 
		initParams = { 
				@WebInitParam(name = "test-param", value = "Initialization Paramter")
		})
public class LogFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LogFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		
		/* Called before the Filter instance is removed from service by the web container*/
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		// Get the IP address of client machine.
	    String ipAddress = request.getRemoteAddr();

	    // Log the IP address and current timestamp.
	    System.out.println("IP "+ ipAddress + ", Time " + new Date().toString());
	    
	    // record the start time
	    long startTime=System.currentTimeMillis();

	    // pass the request along the filter chain
		chain.doFilter(request, response);
		
		//record the end time
		long endTime=System.currentTimeMillis();
		
		//count the performance time in milliseconds
		System.out.println("this service take "+ (endTime-startTime) + " milliseconds");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		
		// Get init parameter 
	    String testParam = fConfig.getInitParameter("test-param"); 

	    //Print the init parameter 
	    System.out.println("Test Param: " + testParam); 
	}

}
