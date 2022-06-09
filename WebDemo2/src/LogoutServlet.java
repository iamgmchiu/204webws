import javax.servlet.*;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.io.IOException;

public class LogoutServlet extends HttpServlet 
{
  private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

  public void init(ServletConfig config) throws ServletException
  {
    super.init(config);
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    request.getSession().invalidate();
    
    response.setContentType(CONTENT_TYPE);
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head><title>LogoutServlet</title></head>");
    out.println("<body>");
    out.println("<p>The User logout and Session has been invalidate.</p>");
    out.println("</body></html>");
    out.close();
  }
}