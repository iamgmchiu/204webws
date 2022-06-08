
import java.io.*;
import java.sql.*;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.naming.*;
import javax.sql.*;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import Bean.Interview;
import Bean.Languages;
import DAO.IntvDAO;

@WebServlet("/InterViewServletDS")
public class InterViewServletDS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("InterViewServletDS doGet start...");
			request.setCharacterEncoding("UTF-8");
			// get connection to DAO
			DataSource ds = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/FindJobDB");
			IntvDAO intvDAO = new IntvDAO(ds.getConnection());

			if (request.getParameter("UpdateId") != null) { // get UpdateId & deliver event to update page
				Interview intvForUpdate = intvDAO.searchByCv_No(Integer.parseInt(request.getParameter("UpdateId")));
				if (intvForUpdate == null) { // check cv_no exist
					getServletContext().getRequestDispatcher("/404.jsp").forward(request, response);
				}
				//intvForUpdate.setLanList(intvForUpdate.getLanguage().split(","));
//				String[] tmp = intvForUpdate.getLanguage().split(",");
				for(String tmp : intvForUpdate.getLanguage().split(",")) {
					for(Languages lans : intvForUpdate.getLanguageArray()) {
						if(lans.getLanguage().equals(tmp)) {
							lans.setCheckStatus("Y");
							break;
						}
					}
				}
				
				
				request.setAttribute("intvForUpdate", intvForUpdate);
				getServletContext().getRequestDispatcher("/IntvUpdate.jsp").forward(request, response);
			} else if (request.getParameter("DeleteId") != null) { // DeleteId exist & do delete
				processDelete(request, response, intvDAO);
			} else { // Event's index
				showData(request, response, intvDAO);
			}
		} catch (NamingException | SQLException | ParseException e) {
			e.printStackTrace();
		}
		System.out.println("InterViewServletDS doGet end...");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("InterViewServletDS doPost start...");
			request.setCharacterEncoding("UTF-8");
			// get connection to DAO
			DataSource ds = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/FindJobDB");
			IntvDAO intvDAO = new IntvDAO(ds.getConnection());
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String[] Languages = request.getParameterValues("Language");
			String langStr = "";
			/**
			 * 獲取陣列資料的技巧，可以避免insts陣列為null時引發的空指標異常錯誤！
			 */
			for (int i = 0; Languages != null && i < Languages.length; i++) {
				if (i == Languages.length - 1) {
					langStr += Languages[i];
				} else {
					langStr += Languages[i] + ",";
				}
			}

			Interview interview = new Interview();
			interview.setCv_No(Integer.parseInt(request.getParameter("cv_no")));
			interview.setInt_Time(request.getParameter("Int_Time"));
			interview.setComp_Name(request.getParameter("Comp_Name"));
			interview.setJob_Name(request.getParameter("Job_Name"));
			interview.setOffer(request.getParameter("Offer"));
			interview.setTest(request.getParameter("Test"));
			interview.setLanguage(langStr);
			interview.setQA(request.getParameter("QA"));
			interview.setShare(request.getParameter("Share"));
			interview.setInt_Score(Integer.parseInt(request.getParameter("Int_Score")));
			interview.setComp_Score(Integer.parseInt(request.getParameter("Comp_Score")));
			interview.setUSER_ID(request.getParameter("USER_ID"));
			interview.setCreated_Time(dtf.format(LocalDateTime.now()));

			if (interview.getCv_No() == 0) { // EventCreate.jsp <input:hidden name="Cv_No" value="0">

				processCreate(request, response, intvDAO, interview);
			} else {
				processUpdate(request, response, intvDAO, interview);
			}

		} catch (NamingException | SQLException | ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("InterViewServletDS doPost end...");
	}

	private void showData(HttpServletRequest request, HttpServletResponse response, IntvDAO intvDAO)
			throws SQLException, IOException, ServletException {
		System.out.println("InterViewServletDS showData start...");
		int page = 1; // default page1
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		List<Interview> interviews = intvDAO.searchByPage(page);

		if (interviews != null) {
			request.setAttribute("interviews", interviews);
			request.setAttribute("pageCount", intvDAO.getPageCount());
			getServletContext().getRequestDispatcher("/IntvDashBoard.jsp").forward(request, response);
		} else {
			getServletContext().getRequestDispatcher("/404.jsp").forward(request, response);
		}
		intvDAO.closeConn();
	}

	private void processDelete(HttpServletRequest request, HttpServletResponse response, IntvDAO intvDAO)
			throws SQLException, IOException, ParseException, ServletException {
		int deleteId = Integer.parseInt(request.getParameter("DeleteId"));

		if (intvDAO.deleteIntv(deleteId)) {
			System.out.println("DeleteId:" + deleteId + " Delete success");
			response.sendRedirect("./InterViewServletDS");
		} else {
			System.out.println("DeleteId:" + deleteId + " Delete fail");
			getServletContext().getRequestDispatcher("/404.jsp").forward(request, response);
		}
		intvDAO.closeConn();
	}

	private void processCreate(HttpServletRequest request, HttpServletResponse response, IntvDAO intvDAO,
			Interview intv) throws SQLException, IOException, ParseException, ServletException {
		if (intvDAO.createIntv(intv)) {
			System.out.println("Create success");
			response.sendRedirect("./InterViewServletDS");
		} else {
			System.out.println("Create fail");
			getServletContext().getRequestDispatcher("/404.jsp").forward(request, response);
		}
		intvDAO.closeConn();
	}

	private void processUpdate(HttpServletRequest request, HttpServletResponse response, IntvDAO intvDAO,
			Interview intv) throws SQLException, IOException, ParseException, ServletException {
		if (intvDAO.updateInterview(intv)) {
			System.out.println("UpdateId:" + intv.getCv_No() + " Update success");
			response.sendRedirect("./InterViewServletDS");
		} else {
			System.out.println("UpdateId:" + intv.getCv_No() + " Update fail");
			getServletContext().getRequestDispatcher("/404.jsp").forward(request, response);
		}
		intvDAO.closeConn();
	}

}