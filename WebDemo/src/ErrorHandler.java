import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class ErrorHandler extends HttpServlet {

  public void doPost(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {
    ErrorMessage errorMessage = (ErrorMessage) request.getAttribute("error-message");
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head><title>Error Page</title></head>");
    out.println("<body>");
    out.println("<H1>"+errorMessage.getTitle()+"</H1>");
    Vector errorDesc = (Vector) errorMessage.getErrorDesc();
    Enumeration errDesc = errorDesc.elements();
    while (errDesc.hasMoreElements()) {
      String message = (String) errDesc.nextElement();
      out.println("Error Message:"+message+"<br>");
    }
    out.println("</body></html>");
    out.close();
  }
}
 
