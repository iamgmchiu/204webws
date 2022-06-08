import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ExceptionHandlerServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		    // 如果要顯示中文訊息，一定要設charset的值。
		    res.setContentType("text/html;charset=UTF-8");
      
			PrintWriter out = res.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h3>Sorry, we have some problem. Please try again later!</h3><p>");
			out.println("<h3>由於系統正在維護，請晚一點再上線試試看!</h3><p>");	
			out.println("<br>status_code="+req.getAttribute("javax.servlet.error.status_code"));
			out.println("<br>exception_type="+req.getAttribute("javax.servlet.error.exception_type"));
			out.println("<br>message="+req.getAttribute("javax.servlet.error.message"));		
			out.println("<br>exception="+req.getAttribute("javax.servlet.error.exception"));
			out.println("<br>request_uri="+req.getAttribute("javax.servlet.error.request_uri"));
			out.println("<br>servlet_name="+req.getAttribute("javax.servlet.error.servlet_name"));		
			
			out.println("</body>");
			out.println("</html>");		
				
	}
}
