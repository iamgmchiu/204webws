

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowBasicInfo
 */
@WebServlet("/ShowBasicInfo2")
public class ShowBasicInfo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowBasicInfo2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		
		
		PrintWriter out = response.getWriter();
		String time1 = request.getParameter("time1");
		String account = request.getParameter("account");
		
		out.println(
				"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
					       "Transitional//EN\n" +
			               "<HTML>\n" +
			               "<HEAD><TITLE>"  + "</TITLE></HEAD>\n" +
				           "<BODY BGCOLOR=\"#FDF5E6\">\n" +
				           "<H1 ALIGN=CENTER>gogo"  + "</H1>\n" +
				           "<UL>\n" +
				           "  <LI><B>time</B>: "
				           + time1 + "\n" +
				           "  <LI><B>name</B>: "
				           + account + "\n" +
				           "</UL>\n" +
				           "</BODY></HTML>"
				
				
				
				
				
				);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
