
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.naming.*;
import javax.sql.*;

import minedemo.Interview;
import minedemo.InterviewDao;



public class InterViewServletDS extends HttpServlet {
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
      InterviewDao interviewDao = new InterviewDao(conn);
//      Interview InterviewData = (Interview)request.getSession(true).getAttribute("reg_Interview");
      //如果要編碼值為UTF-8
     request.setCharacterEncoding("UTF-8");

      if (request.getParameter("QUERY") != null) {
        processQuery(request,response,interviewDao);
      } 

      if (request.getParameter("INSERT") != null) {
    	  gotoSubmitProcess(request,response,interviewDao);
      } 
      if (request.getParameter("DELETE") != null) {
    	  deleteServlet(request,response,interviewDao);
      } 
      if (request.getParameter("UPDATE") != null) {
    	  processUpdate(request,response,interviewDao);
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

  public void processUpdate(HttpServletRequest request,
                             HttpServletResponse response,
                             InterviewDao interviewDao) throws SQLException, IOException {
	  String Cv_No;
	  //讀取部門代號
	  Cv_No = request.getParameter("Cv_No");
	  String Created_Time = request.getParameter("Created_Time").trim();
	  String  Int_Time = request.getParameter("Int_Time").trim();
	  String Comp_Name = request.getParameter("Comp_Name").trim();
	  String Job_Name = request.getParameter("Job_Name").trim();
	  String  Offer = request.getParameter("Offer").trim();
	  String  Test = request.getParameter("Test").trim();
	  String Language = request.getParameter("Language").trim();
	  String  QA = request.getParameter("QA").trim();
	  String   Share = request.getParameter("Share").trim();
	  String  Int_Score = request.getParameter("Int_Score").trim();
	  String Comp_Score = request.getParameter("Comp_Score").trim();
	  String USER_ID = request.getParameter("USER_ID").trim();
    
    Interview interview = interviewDao.selectByCv_No(Integer.parseInt(Cv_No));
    if (interview == null) showError(response, " can not find this comp_Name" + Comp_Name);
    else {
      interview.setCreated_Time(Created_Time);
      interview.setInt_Time(Int_Time);
      interview.setComp_Name(Comp_Name);
      interview.setJob_Name(Job_Name);
      interview.setOffer(Offer);
      interview.setTest(Test);
      interview.setLanguage(Language);
      interview.setQA(QA);
      interview.setShare(Share);
      interview.setInt_Score(Int_Score);
      interview.setComp_Score(Comp_Score);
      interview.setUSER_ID(USER_ID);
      if (interviewDao.updateDept(interview)) showForm(response,interview);
      else showError(response," update failure");
    }
  }

  public void gotoSubmitProcess(HttpServletRequest request, HttpServletResponse response,InterviewDao interviewDao) throws ServletException, IOException
  {//輸入資料
	   String Created_Time;
	     String Int_Time;
	     String Comp_Name;
	     String Job_Name;
	     String Offer;
	     String Test;
	     String Language;
	     String QA;
	     String Share;
	     String Int_Score;
	     String Comp_Score;
	     String USER_ID;
   
	     Created_Time = request.getParameter("Created_Time").trim();
	     Int_Time = request.getParameter("Int_Time").trim();
	     Comp_Name = request.getParameter("Comp_Name").trim();
	     Job_Name = request.getParameter("Job_Name").trim();
	     Offer = request.getParameter("Offer").trim();
	     Test = request.getParameter("Test").trim();
	     Language = request.getParameter("Language").trim();
	     QA = request.getParameter("QA").trim();
	     Share = request.getParameter("Share").trim();
	     Int_Score = request.getParameter("Int_Score").trim();
	     Comp_Score = request.getParameter("Comp_Score").trim();
	     USER_ID = request.getParameter("USER_ID").trim();
	     Interview interview = new Interview(Created_Time, Int_Time, Comp_Name, Job_Name, Offer, Test, Language, QA, Share, Int_Score, Comp_Score, USER_ID);
	    interviewDao.createInterview(interview);
	    System.out.println("新增成功");
	    if(interview!=null)showForm(response, interview);
	     /*request.getSession(true).setAttribute("reg_Interview",reg_Interview);*/
   /* request.getRequestDispatcher("/DisplayStudent.jsp").forward(request,response);*/
  }
  
  public void deleteServlet(HttpServletRequest request, 
          HttpServletResponse response,
          InterviewDao interviewDao) throws SQLException,IOException{
	  
	  String cv_No ;
	  cv_No=request.getParameter("Cv_No");
	  Interview interview=new Interview();
	  interviewDao.deleteInterview(Integer.parseInt(request.getParameter("Cv_No")));
  }
  
  public void processQuery(HttpServletRequest request, 
                            HttpServletResponse response,
                            InterviewDao interviewDao) throws SQLException,IOException {
	  String Cv_No;
	  //讀取部門代號
	  Cv_No = request.getParameter("Cv_No");

    //透過DAO元件Access interview Table
	  Interview interview=interviewDao.selectByCv_No(Integer.parseInt(Cv_No));
    if (interview == null) showError(response, " can not find this cv_No" + Cv_No);
    else              showForm(response, interview);

  }

  private void showError(HttpServletResponse response, String message)
                  throws IOException  {
    PrintWriter out = response.getWriter();
    out.println("<HTML>");
    out.println("<HEAD>");
    out.println("<TITLE>Interview Form</TITLE>");
    out.println("</HEAD>");
    out.println("<BODY BGCOLOR='#FDF5E6'>");
    out.println("message:"+ message);                  
    out.println("</BODY>");
    out.println("</HTML>");  
    out.close();
  }

  private void showForm(HttpServletResponse response, Interview interview)
                  throws IOException  {
	  
    response.setContentType("text/html;charset=UTF-8");              
    PrintWriter out = response.getWriter();
    out.println("<HTML>");
    out.println("<HEAD>");
    out.println("<TITLE>Interview Form</TITLE>");
    out.println("</HEAD>");
    out.println("<BODY BGCOLOR='#FDF5E6'>");
    out.println("<H1 ALIGN='CENTER'>Interview Form</H1>");                  
    out.println("<FORM ACTION='./InterViewServletDS'>");
    
    out.println(" CV_NO  :  "+interview.getCv_No());
    out.println(" CV_NO  :  <INPUT TYPE='TEXT' NAME='CV_NO' VALUE='"+interview.getCv_No()+"'><BR>");
    out.println(" Created_Time  :  <INPUT TYPE='TEXT' NAME='Created_Time' VALUE='"+interview.getCreated_Time()+"'><BR>");
    out.println(" Int_Time  :  <INPUT TYPE='TEXT' NAME='Int_Time' VALUE='"+interview.getInt_Time()+"'><BR>");
    out.println(" Comp_Name  :  <INPUT TYPE='TEXT' NAME='Comp_Name' VALUE='"+interview.getComp_Name()+"'><BR>");
    out.println(" Job_Name  :  <INPUT TYPE='TEXT' NAME='Job_Name' VALUE='"+interview.getJob_Name()+"'><BR>");
    out.println(" Offer  :  <INPUT TYPE='TEXT' NAME='Offer' VALUE='"+interview.getOffer()+"'><BR>");
    out.println(" Test  :  <INPUT TYPE='TEXT' NAME='Test' VALUE='"+interview.getTest()+"'><BR>");
    out.println(" Language  :  <INPUT TYPE='TEXT' NAME='Language' VALUE='"+interview.getLanguage()+"'><BR>");
    out.println(" QA  :  <INPUT TYPE='TEXT' NAME='QA' VALUE='"+interview.getQA()+"'><BR>");
    out.println(" Share  :  <INPUT TYPE='TEXT' NAME='Share' VALUE='"+interview.getShare()+"'><BR>");
    out.println(" Int_Score  :  <INPUT TYPE='TEXT' NAME='Int_Score' VALUE='"+interview.getInt_Score()+"'><BR>");
    out.println(" Comp_Score  :  <INPUT TYPE='TEXT' NAME='Comp_Score' VALUE='"+interview.getComp_Score()+"'><BR>");
    out.println(" USER_ID  :  <INPUT TYPE='TEXT' NAME='USER_ID' VALUE='"+interview.getUSER_ID()+"'><BR>");
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