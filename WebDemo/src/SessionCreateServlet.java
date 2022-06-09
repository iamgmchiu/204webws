
import java.io.*;
import java.util.Enumeration;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;


public class SessionCreateServlet extends HttpServlet { 

    public void doGet (HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException
      {
      //Get the session object
	  HttpSession session = req.getSession(true);
        
	  // set content type and other response header fields first
	  res.setContentType("text/html");

	  // then write the data of the response
	  PrintWriter out = res.getWriter();
	  
	  String _sval = (String)session.getAttribute("counter");
	  int _counter=1;
	  
	  if(_sval!=null)
	  {
	  	_counter=Integer.parseInt(_sval);
	  	_counter++;
	  }
	
	    
//	  int _counter = _sval ==null? 1 : (int)Integer.parseInt(_sval)++;
	  session.setAttribute("counter",String.valueOf(_counter));

	  out.println("<HEAD><TITLE> " + "Session Created Successfully .. Look at the Console to see whether the HTTPSessionEvent invoked " +
		      "</TITLE></HEAD><BODY>");
      out.println("<P>[<A HREF=\"SessionCreateServlet\">Reload</A>]&nbsp;");	
      out.println("[<A HREF=\"SessionDestroyServlet\">Destroy Session</A>]");	
	  out.println("<h2>Session created Successfully</h2>");
	  out.println("Look at the the Console to see whether the HTTPSessionEvent was invoked");
	  out.println("<h3>Session Data:</h3>");
	  out.println("New Session: " + session.isNew());
	  out.println("<br>Session ID: " + session.getId());
	  out.println("<br>Creation Time: " + new Date(session.getCreationTime()));
	  out.println("<br>Last Accessed Time: " + new Date(session.getLastAccessedTime()));
	  out.println("<BR>Number of Accesses: " + session.getAttribute("counter"));
          
      }
    }
