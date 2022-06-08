
import javax.servlet.*;
//import javax.servlet.http.*;
//import java.io.PrintWriter;
//import java.io.IOException;
import mvcdemo.bean.*;
import java.io.*;

import java.sql.*;
//import javax.rmi.*;
import javax.naming.*;
import javax.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	 private static final String CHARSET_CODE = "UTF-8";
	 public void init(ServletConfig config) throws ServletException
	 {
	   super.init(config);
	 }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    System.out.println("now doPost in...");
		request.setCharacterEncoding(CHARSET_CODE);
	    response.setContentType(CONTENT_TYPE);

	    // To prevent caching 
	   response.setHeader("Cache-Control","no-cache"); // HTTP 1.1
	   response.setHeader("Pragma","no-cache"); // HTTP 1.0
	   response.setDateHeader ("Expires", -1); // Prevents caching at the proxy server
	   

	    
	   if (request.getParameter("submit")!=null)
	     gotoSubmitProcess(request, response);
	   else if (request.getParameter("confirm")!=null)
		   request.getRequestDispatcher("/DisplayStudent.jsp");
	   request.getSession(true).invalidate();
       request.getRequestDispatcher("/Thanks.jsp").forward(request,response);
//		   gotoConfirmProcess(request, response);
	    System.out.println("out doPost ...");
}
	
	 public void gotoSubmitProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	  {System.out.println("now gotoSubmitProcess...");
	    String name;
	    String birth;
	    String id;
	    String gender;
	    String zipcode;
	    String address;
	    String phone;
	    String mailaddress;
	   
	    name = request.getParameter("name").trim();
	    birth = request.getParameter("birth").trim();
	    id = request.getParameter("id").trim();
	    gender = request.getParameter("gender").trim();
	    zipcode = request.getParameter("zipcode").trim();
	    address = request.getParameter("address").trim();
	    phone = request.getParameter("phone").trim();
	    mailaddress = request.getParameter("mailaddress").trim();
	    
	    StudentBean reg_student =  new StudentBean(name, birth,id,gender, zipcode, address, phone, mailaddress );
	    request.getSession(true).setAttribute("reg_student",reg_student);
	    request.getRequestDispatcher("/DisplayStudent.jsp").forward(request,response);
	    System.out.println("out gotoSubmitProcess...");
	  }
}
