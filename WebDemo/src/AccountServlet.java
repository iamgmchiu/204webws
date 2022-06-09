import java.io.*;
import java.net.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

/*
 * This servlet simply prints out HTTP method name and query string in it's service method.
 * 
 * 
 * Servlet implementation class AccountServlet
 */

public class AccountServlet extends HttpServlet 
{
	Hashtable data = new Hashtable();
	
	//If somebody types up the URL for this servlet 
	//in the address field of the browser.
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException, java.io.IOException 
	{
		doPost(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException, java.io.IOException 
	{
		//get the userid set by LoginServlet
		String userid = (String) req.getAttribute("userid");

		if(userid != null )
		{
			// userid available. retrieve the data and generate the page.
			String[] records = (String[]) data.get(userid);

			PrintWriter out = res.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h3>Account Status for "+userid+" at the start of previous three months...</h3><p>");				
			for(int i=0; i<records.length; i++)
			{
				out.println(records[i]+"<br>");
			}

			out.println("</body>");
			out.println("</html>");						
		}
		else
		{

			//No userid. Send login.html to the user.
			//observe the use of relative path.
			req.getRequestDispatcher("/login.html").forward(req, res);
		}			
	}
  
	public void init()
	{
		data.put("ann", new String[]{ "01/01/2001 : 1000.00", "01/02/2001 : 1300.00", "01/03/2001 : 900.00"} );				
		data.put("john", new String[]{ "01/01/2001 : 4500.00", "01/02/2001 : 2100.00", "01/03/2001 : 2600.00"} );
		data.put("mark", new String[]{ "01/01/2001 : 7800.00", "01/02/2001 : 5200.00", "01/03/2001 : 1900.00"} );
	}
}



