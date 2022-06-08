package ebookshop;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.sql.DataSource;
import javax.naming.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MySQLTestServlet
 */
@WebServlet("/MySQLTestServlet")
public class MySQLTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DataSource ds;
	
	@Override
	public void init( ) throws ServletException {
	   try {
	      // Create a JNDI Initial context to be able to lookup the DataSource
	      InitialContext ctx = new InitialContext();
	      // Lookup the DataSource, which will be backed by a pool
	      //   that the application server provides.
	      ds = (DataSource)ctx.lookup("java:comp/env/jdbc/EmployeeDB");
	      if (ds == null)
	         throw new ServletException("Unknown DataSource 'jdbc/EmployeeDB'");
	  } catch (NamingException ex) {
	      ex.printStackTrace();
	  }
   }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	      // Set the response message's MIME type
	      response.setContentType("text/html;charset=UTF-8");
	      // Allocate a output writer to write the response message into the network socket
	      PrintWriter out = response.getWriter();
	 
	      Connection conn = null;
	      Statement  stmt = null;
	      
	      try {
	         out.println("<!DOCTYPE html>");
	         out.println("<html>");
	         out.println("<head><title>Qurey Servlet</title></head>");
	         out.println("<body>");
	         out.println("<h2>Results</h2>");
	         out.println("<table border=\\\"1\">");
	         out.println("<th>author</th>");
	         out.println("<th>title</th>");
	        
	         	 
	         // Get a connection from the pool
	         conn = ds.getConnection();
	 
	         // Normal JBDC programming hereafter. Close the Connection to return it to the pool
	         stmt = conn.createStatement();
	         ResultSet rset = stmt.executeQuery("SELECT author, title FROM books");
	         int count=0;
	         while(rset.next()) {
	        	out.println("<tr>");
	            out.println("<td>" + rset.getString("author") + "</td>");
	            out.println("<td>" + rset.getString("title") + "</td>");
	            out.println("</tr>");
	            ++count;
	         }
	       
	         out.println("</table>");
	         out.println("</body></html>");
	      } catch (SQLException ex) {
	         ex.printStackTrace();
	      } finally {
	         out.close();
	         try {
	            if (stmt != null) stmt.close();
	            if (conn != null) conn.close();  // return to pool
	         } catch (SQLException ex) {
	             ex.printStackTrace();
	         }
	      }
	}

}
