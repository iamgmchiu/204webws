

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowMessage
 */
public class ShowMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String message;
	private String defaultMessage = "No message.";
	private int repeats = 1;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		// Always call super.init
	    super.init(config);
	    message = config.getInitParameter("message");
	    if (message == null) {
	      message = defaultMessage;
	    }
	    try {
	      String repeatString = config.getInitParameter("repeats");
	      repeats = Integer.parseInt(repeatString);
	    } catch(NumberFormatException nfe) {
	      // NumberFormatException handles case where repeatString
	      // is null *and* case where it is something in an
	      // illegal format. Either way, do nothing in catch,
	      // as the previous value (1) for the repeats field will
	      // remain valid because the Integer.parseInt throws
	      // the exception *before* the value gets assigned
	      // to repeats.
	      // repeats = 1;
	    }
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    String title = "The ShowMessage Servlet";
	    out.println(
	    		    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
			        "Transitional//EN\n" +
	                "<HTML>\n" +
	                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
	                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
	                "<H1 ALIGN=CENTER>" + title + "</H1>");
	    for(int i=0; i<repeats; i++) {
	      out.println(message + "<BR>");
	    }
	    out.println("</BODY></HTML>");
	}

}
