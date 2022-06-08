

import java.io.IOException;
import java.text.MessageFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author gacl 獲取用戶端通過Form表單提交上來的參數
 */
@WebServlet("/RequestDemo03")
public class RequestDemo03 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		/**
		 * 編 號(文字方塊)：
		 * <input type="text" name="userid" value="NO." size="2" maxlength="2">
		 */
		String userid = request.getParameter("userid");// 獲取填寫的編號，userid是文字方塊的名字，<input type="text" name="userid">
		/**
		 * 用戶名(文字方塊)：<input type="text" name="username" value="請輸入用戶名">
		 */
		String username = request.getParameter("username");// 獲取填寫的用戶名
		/**
		 * 密 碼(密碼框)：<input type="password" name="userpass" value="請輸入密碼">
		 */
		String userpass = request.getParameter("userpass");// 獲取填寫的密碼
		String sex = request.getParameter("sex");// 獲取選中的性別
		String dept = request.getParameter("dept");// 獲取選中的部門
		// 獲取選中的興趣，因為可以選中多個值，所以獲取到的值是一個字串陣列，因此需要使用getParameterValues方法來獲取
		String[] insts = request.getParameterValues("inst");
		String note = request.getParameter("note");// 獲取填寫的說明資訊
		String hiddenField = request.getParameter("hiddenField");// 獲取隱藏欄位的內容

		String instStr = "";
		/**
		 * 獲取陣列資料的技巧，可以避免insts陣列為null時引發的空指標異常錯誤！
		 */
		for (int i = 0; insts != null && i < insts.length; i++) {
			if (i == insts.length - 1) {
				instStr += insts[i];
			} else {
				instStr += insts[i] + ",";
			}
		}

		String htmlStr = "<table>" + "<tr><td>填寫的編號：</td><td>{0}</td></tr>" + "<tr><td>填寫的用戶名：</td><td>{1}</td></tr>"
				+ "<tr><td>填寫的密碼：</td><td>{2}</td></tr>" + "<tr><td>選中的性別：</td><td>{3}</td></tr>"
				+ "<tr><td>選中的部門：</td><td>{4}</td></tr>" + "<tr><td>選中的興趣：</td><td>{5}</td></tr>"
				+ "<tr><td>填寫的說明：</td><td>{6}</td></tr>" + "<tr><td>隱藏欄位的內容：</td><td>{7}</td></tr>" + "</table>";
		htmlStr = MessageFormat.format(htmlStr, userid, username, userpass, sex, dept, instStr, note, hiddenField);

		response.setCharacterEncoding("UTF-8");// 設置伺服器端以UTF-8編碼輸出資料到用戶端
		response.setContentType("text/html;charset=UTF-8");// 設置用戶端流覽器以UTF-8編碼解析資料
		response.getWriter().write(htmlStr);// 輸出htmlStr裡面的內容到用戶端流覽器顯示

	}
}
