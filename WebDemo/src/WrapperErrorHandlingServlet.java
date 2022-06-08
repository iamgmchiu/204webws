
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class WrapperErrorHandlingServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
    try {
			PrintWriter out = res.getWriter();
			out.println("<p>Just throw the exception and do not catch it....</p>");
            throw new SQLException("There is something wrong in the Database, please inform the DBA,請通知資料庫管員");
    }  
    catch (SQLException sqle) {
			throw new ServletException(sqle);
		}
	}
}
