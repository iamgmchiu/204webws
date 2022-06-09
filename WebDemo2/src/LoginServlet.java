import javax.servlet.*;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.io.IOException;

public class LoginServlet extends HttpServlet 
{
  private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

  public void init(ServletConfig config) throws ServletException
  {
    super.init(config);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    String userid = request.getParameter("userid");
    String userpasswd = request.getParameter("userpasswd");
    
    LoginedUser loginedUser = new LoginedUser(userid,userpasswd);
    
    HttpSession session = request.getSession(true);
    session.setAttribute("loginedUser",loginedUser);
    
    response.setContentType(CONTENT_TYPE);
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head><title>LoginServlet</title></head>");
    out.println("<body>");
    out.println("<p>Please wait 1 minute, to let the active session time out.</p>");
    out.println("<p>or you can click the logout link to invalidate the session<p>");

    //URL rewriting
    //String formedURL = response.encodeRedirectURL("./LogoutServlet"); 
    String formedURL = response.encodeURL("./LogoutServlet");

    out.println("<a href=\""+ formedURL + "\">Logout</a><br>");
    out.println("</body></html>");
    out.close();
  }
}