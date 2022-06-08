

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterFormServlet
 */
@WebServlet("/RegisterFormServlet")
public class RegisterFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    String title = "報名資料確認";
	    String account = request.getParameter("account");
	    String school = request.getParameter("school");
	    String department = request.getParameter("department");
	    String gender = request.getParameter("gender");
	    String[] transportation = request.getParameterValues("transportation");
	    
	    
out.println(
		"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
			       "Transitional//EN\n" +
	               "<HTML>\n" +
	               "<HEAD><TITLE>"  + "</TITLE></HEAD>\n" +
		           "<BODY BGCOLOR=\"#FDF5E6\">\n" +
		           "<H1 ALIGN=CENTER>"+"<BR>"+title  + "</H1>\n" +
		           "姓名:"+"<BR>"+account+"<BR><BR>\n"+
		           "畢業學校:"+"<BR>"+school+"<BR><BR>\n"+
		           "畢業科系:"+"<BR>"+department+"<BR><BR>\n"+
		           "性別:"+"<BR>"+gender+"<BR><BR>\n"+
		           "交通工具:"+"<BR>"		
		);
for (String string : transportation) {
	out.println("<div>"+string+"</div>");
}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
