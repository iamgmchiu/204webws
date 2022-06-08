

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GreetingServlet
 */
public class GreetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String greetingMessage;
    private String defaultMessage = "No message.";
  
	public void init() throws ServletException {
	    ServletConfig config = this.getServletConfig();
	    greetingMessage = config.getInitParameter("greetingText");
	    if (greetingMessage == null) 
	    {
	      greetingMessage = defaultMessage;
	    }
	  }
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
	      
	    PrintWriter out = response.getWriter();
	    String title = "The Greeting Servlet";
	    out.println("<html><title>" + title + "</title>" +
	                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
	                "<H1 ALIGN=CENTER>" + title + "</H1>");
	    out.println("ServletName:");            
	    out.println(this.getServletName()+"<BR>");
	    out.println("GreetingMessage:");
	    out.println(greetingMessage + "<BR>");
	    out.println("</BODY></HTML>");
	    out.close();
	}

}
