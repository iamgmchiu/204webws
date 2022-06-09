

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CounterServlet
 */
public class CounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String CONTENT_TYPE = "text/html";

	public void init() throws ServletException 
	  {
	    ServletContext context = this.getServletContext();
	    ServletConfig config = this.getServletConfig();
	    String relativePathName = null;
	    String realPathName = null;
	    String visitingCounterNo = null;
	    FileReader fileReader = null;
	    BufferedReader bufferedReader = null;
	        
	    try {
	      
	      relativePathName = config.getInitParameter("VisitingCounterNoFileName");


	      
	      
	      //case 1 : using ServletContext getResourceAsStream() method
	     
	      InputStream inStream = context.getResourceAsStream(relativePathName);
	      bufferedReader = new BufferedReader(new InputStreamReader(inStream));
	      
	      realPathName = context.getRealPath(relativePathName); //���ӭn�O�o�[�W�o�@��{���X
	      
	      
	      //case 2 : using general IO methods
	      
	      /*
	      realPathName = context.getRealPath(relativePathName);
	      
	      fileReader = new FileReader(realPathName);
	      bufferedReader = new BufferedReader(fileReader);
	      */
	      
	      visitingCounterNo = bufferedReader.readLine();
	      if (visitingCounterNo == null) visitingCounterNo="0";
	    }
	    catch (FileNotFoundException fnfe){
	      context.log("FileNotFound", fnfe);
	      visitingCounterNo = "0";
	    }
	    catch (IOException ioe) {
	      context.log("IOException", ioe);
	    }
	    finally 
	   {    
	      
	      try{
	        if (bufferedReader != null) {
	          bufferedReader.close();
	        }
	      } 
	      catch (IOException ioe){}
	    }

	   
	    context.setAttribute("visitingCounterNo",visitingCounterNo);
	    context.setAttribute("realPathName",realPathName);
	    return;
	  }

	
	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	  {
	    response.setContentType(CONTENT_TYPE);
	    ServletContext context = this.getServletContext();
	    String localVisitingCounterNo = null;

	    synchronized (context) {  
	      localVisitingCounterNo = (String) context.getAttribute("visitingCounterNo"); 
	      localVisitingCounterNo = String.valueOf((Integer.parseInt(localVisitingCounterNo)+1));
	      context.setAttribute("visitingCounterNo",localVisitingCounterNo);
	    }  

	    PrintWriter out = response.getWriter();
	    out.println("<html>");
	    out.println("<head><title>Show Visiting Counter No.</title></head>");
	    out.println("<body>");
	    out.println("<p>The Current Visiting No. is "+ localVisitingCounterNo +" </p>");
	    out.println("</body></html>");
	    out.close();
	  }

	  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	  {
	    this.doGet(request, response);
	  }
	  
	  public void destroy() 
	  {
	    ServletContext context = this.getServletContext();
	    ServletConfig config = this.getServletConfig();
	    FileWriter fileWriter = null;
	    PrintWriter printWriter = null;
	    BufferedWriter bufferedWriter = null;

	    try {
	      String realPathName = (String) context.getAttribute("realPathName");

	      fileWriter = new FileWriter(realPathName);
	      bufferedWriter = new BufferedWriter(fileWriter);
	      printWriter = new PrintWriter(bufferedWriter);
	      String visitingCounterNo = (String) context.getAttribute("visitingCounterNo");
	      printWriter.println(visitingCounterNo);
	    }
	    catch (IOException ioe){
	      context.log("Cannot write visitingCounterNo to file", ioe);
	    }
	    finally {
	      if (printWriter != null) {
	        printWriter.close();
	      }
	    }

	    return;    
	  }
	
	
}
