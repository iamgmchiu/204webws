import java.io.*;
import java.net.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

/*
 * This servlet simply prints out HTTP method name and query string in it's service method.
 * 
 *
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet 
{
	Hashtable users = new Hashtable();
	
	//If somebody types up the URL for this servlet 
	//in the address field of the browser.
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException, java.io.IOException 
	{
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException, java.io.IOException 
	{		
		String userid = req.getParameter("userid");
		String password = req.getParameter("password");		

		if(userid != null && password != null && password.equals((String)users.get(userid)) )
		{
			//set userid in request to pass it on to AccountServlet
			req.setAttribute("userid", userid);
			
			//userid,password verified. Forward request to AccountServlet.
			//observe the use of absolute path.
			req.getRequestDispatcher("/AccountServlet").forward(req, res);
      
			return;
		}
		else
		{
			//Unable to login. Send login.html to the user.
			//observe the use of relative path.
			req.getRequestDispatcher("/login.html").forward(req, res);
			return;			
		}

	}
	public void init()
	{
		users.put("ann", "aaa");				
		users.put("john", "jjj");
		users.put("mark", "mmm");
	}
}


