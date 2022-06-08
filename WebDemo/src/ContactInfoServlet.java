import javax.servlet.*;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * Servlet implementation class ContactInfoServlet
 */
public class ContactInfoServlet extends HttpServlet 
{
  private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

  public void init(ServletConfig config) throws ServletException
  {
    super.init(config);
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    response.setContentType(CONTENT_TYPE);
    ServletContext context = this.getServletContext();
    String webmaster = context.getInitParameter("webmaster");
    
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head><title>ContactInfoServlet</title></head>");
    out.println("<body>");
    out.println("<h1>Contact Information Servlet Demo</h1>");
    out.println("<hr>");
    out.println("<p>contact webmaster:</p>");
    out.println("<a href=\"mailto:" + webmaster +"\" title=\"EmailBox\">EmailBox</a>");
    out.println("</body></html>");
    out.close();
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    doGet(request, response);
  }
}
