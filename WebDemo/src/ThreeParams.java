

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ThreeParams
 */
public class ThreeParams extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	  request.setCharacterEncoding("UTF-8");  //setup response character encoding type
	  
	  response.setContentType("text/html");   //setup response content type
	  response.setCharacterEncoding("UTF-8"); //setup response character encoding type
	  
	  
	  //response.setHeader("content-type","text/html;charset=UTF-8");
	  //response.setContentType("text/html;charset=UTF8");
	  PrintWriter out = response.getWriter();
	  String title = "Reading Three Request Parameters";
	  
	 // String param1 = new String(request.getParameter("param1").getBytes("iso-8859-1"), "UTF-8");
	 // String param2 = new String(request.getParameter("param2").getBytes("iso-8859-1"), "UTF-8");
	 // String param3 = new String(request.getParameter("param3").getBytes("iso-8859-1"), "UTF-8");
	  
	  String param1 = request.getParameter("param1");
	  String param2 = request.getParameter("param2");
	  String param3 = request.getParameter("param3");
	  
	  out.println(			  
			       "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
			       "Transitional//EN\n" +
	               "<HTML>\n" +
	               "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
		           "<BODY BGCOLOR=\"#FDF5E6\">\n" +
		           "<H1 ALIGN=CENTER>" + title + "</H1>\n" +
		           "<UL>\n" +
		           "  <LI><B>param1</B>: "
		           + param1 + "\n" +
		           "  <LI><B>param2</B>: "
		           + param2 + "\n" +
		           "  <LI><B>param3</B>: "
		           + param3 + "\n" +
		           "</UL>\n" +
		           "</BODY></HTML>");	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	
	}

}
