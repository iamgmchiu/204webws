import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Resume extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response) 
           throws ServletException, IOException {
     PrintWriter out = response.getWriter();
     response.setContentType("text/html");
     out.println("<html><head><title>RESUME Demo</title></head>");
     out.println("<body>");
     String url = "'Resume'";
     out.println("<h1>RESUME PAGE</h1>");
     out.println("<form action="+url+" method='post' >");
     out.println("Name : <input type='text' name='name'><br><br>");
     out.println("Identification: <input type='text' name='id'><br><br>");
     out.println("<input type='submit'>");
     out.println("</form></body></html>");
     out.close();
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
    processRequest(request,response);
  }    

  public void processRequest(HttpServletRequest request, HttpServletResponse response) 
           throws ServletException, IOException {

    
    ErrorMessage errorMessage = new ErrorMessage();   
    errorMessage.setTitle("RESUME PAGE");

    
    String name = request.getParameter("name");
    String id   = request.getParameter("id");

    
    if ((name == null) || (name.equals("")) ) {

      errorMessage.setErrorFlag(true);
      errorMessage.setErrorDesc("Name can't be space");
    }
  
  
    if ( (id == null) || (id.equals("")) ) {
      errorMessage.setErrorFlag(true);
      errorMessage.setErrorDesc("Identification can't be space");
    }

   
    
    if (errorMessage.getErrorFlag()) {  

      
      request.setAttribute("error-message",errorMessage);

      
      
      RequestDispatcher errorPage = getServletContext().getNamedDispatcher("ErrorHandler");   
      //RequestDispatcher errorPage = getServletContext().getRequestDispatcher("/ErrorServlet");

      errorPage.forward(request,response);
      return;
    } else {
      Person person = new Person();
      person.setName(name);
      request.setAttribute("new-comer",person);      
      thankPage(request,response);
      return;
    }
  }

  public void thankPage(HttpServletRequest request, HttpServletResponse response) 
           throws ServletException, IOException {
    Person newComer = (Person) request.getAttribute("new-comer");
    PrintWriter out = response.getWriter();
    response.setContentType("text/html");
    out.println("<html><head><title>Welcome</title></head><body>");
    out.println("<h1>WELCOME</h1>");
    out.println("<p>Hi!!"+newComer.getName());
    out.println("</body></html>");
    out.close();   
  }  

}
