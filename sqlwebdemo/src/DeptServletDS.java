import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.naming.*;
import javax.sql.*;


public class DeptServletDS extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {
    
	DataSource ds = null;
    InitialContext ctxt = null;
    Connection conn = null;
    
    
    try {
     
      //建立Context Object,連到JNDI Server
      ctxt = new InitialContext();

      //使用JNDI API找到DataSource
      ds = ( DataSource ) ctxt.lookup("java:comp/env/jdbc/EmployeeDB");
     
      //向DataSource要Connection
      conn = ds.getConnection();

      //建立Database Access Object,負責Table的Access
      DeptDAO deptDAO = new DeptDAO(conn);

      //如果要編碼值為UTF-8
     request.setCharacterEncoding("UTF-8");

      if (request.getParameter("QUERY") != null) {
        processQuery(request,response,deptDAO);
      } 

      if (request.getParameter("UPDATE") != null) {
        processUpdate(request,response,deptDAO);
      } 
    } catch (NamingException ne) {
      System.out.println("Naming Service Lookup Exception");  
    } catch (SQLException e) {
      System.out.println("Database Connection Error"); 
    } finally {
      try {
        if (conn != null) conn.close();
      } catch (Exception e) {
        System.out.println("Connection Pool Error!");
      }
    }
  }

  private void processUpdate(HttpServletRequest request,
                             HttpServletResponse response,
                             DeptDAO deptDAO) throws SQLException, IOException {
    String deptno = request.getParameter("deptno");
    String dname = request.getParameter("dname");
    
    Dept dept = deptDAO.findDept(Integer.parseInt(deptno));
    if (dept == null) showError(response, " can not find this department no" + deptno);
    else {
      dept.setDname(dname);
      if (deptDAO.updateDept(dept)) showForm(response,dept);
      else showError(response," update failure");
    }
  }

  private void processQuery(HttpServletRequest request, 
                            HttpServletResponse response,
                            DeptDAO deptDAO) throws SQLException,IOException {
	//讀取部門代號
    String deptno = request.getParameter("deptno");

    //透過DAO元件Access Dept Table
    Dept dept = deptDAO.findDept(Integer.parseInt(deptno));
    if (dept == null) showError(response, " can not find this department no" + deptno);
    else              showForm(response, dept);

  }

  private void showError(HttpServletResponse response, String message)
                  throws IOException  {
    PrintWriter out = response.getWriter();
    out.println("<HTML>");
    out.println("<HEAD>");
    out.println("<TITLE>Department Form</TITLE>");
    out.println("</HEAD>");
    out.println("<BODY BGCOLOR='#FDF5E6'>");
    out.println("message:"+ message);                  
    out.println("</BODY>");
    out.println("</HTML>");  
    out.close();
  }

  private void showForm(HttpServletResponse response, Dept dept)
                  throws IOException  {
	  
    response.setContentType("text/html;charset=UTF-8");              
    PrintWriter out = response.getWriter();
    out.println("<HTML>");
    out.println("<HEAD>");
    out.println("<TITLE>Department Form</TITLE>");
    out.println("</HEAD>");
    out.println("<BODY BGCOLOR='#FDF5E6'>");
    out.println("<H1 ALIGN='CENTER'>Department Form</H1>");                  
    out.println("<FORM ACTION='./DeptServletDS'>");
    out.println("Department No:<INPUT TYPE='TEXT' NAME='deptno' VALUE='" +
                dept.getDeptno() + "'><BR>");
    out.println("Department Name:  <INPUT TYPE='TEXT' NAME='dname' VALUE='" +
                dept.getDname() + "'><BR>");
    out.println("  <CENTER>");
    out.println("<INPUT NAME='QUERY'  TYPE='SUBMIT' VALUE='QUERY'>");
    out.println("<INPUT NAME='UPDATE' TYPE='SUBMIT' VALUE='UPDATE'>");
    out.println("</CENTER>");
    out.println("</FORM>");
    out.println("</BODY>");
    out.println("</HTML>");  
    out.close();
  }

}