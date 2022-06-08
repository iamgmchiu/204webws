

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
	    out.println("<html>");
	    out.println("<head><title>HelloWorldServlet Sample</title></head>");
	    out.println("<body>");
	    out.println("<p><H1>HelloWorld Servlet Sample Demo</H1></p>");
	    out.println("<p>Current Server System Time: " + new Date()+ "</P>");
	    out.println("</body></html>");
	    out.close();
	}

}
