import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.Random;
import java.util.stream.Collectors;

import javax.imageio.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/*
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
*/

/**
 * Servlet implementation class Password
 */
public class Password extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Password() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("image/jpeg");

        String passwd = new Random().ints(0, 10)
                                    .limit(4)
                                    .mapToObj(String::valueOf)
                                    .collect(Collectors.joining());

        // 實際場合必須將產生的驗證碼存在某個地方，以供之後比對

        ImageIO.write(
            passwordImage(passwd), 
            "JPG", 
            response.getOutputStream()
        );    
        
	}

	// 一些 Java 2D 的東西，作用為依傳入的數字產生圖片
    private BufferedImage passwordImage(String password) throws IOException {
        BufferedImage bufferedImage =
                 new BufferedImage(60, 20, BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.getGraphics();
        g.setColor(Color.WHITE);
        g.setFont(new Font("標楷體", Font.BOLD, 16));
        g.drawString(password, 10, 15);
        return bufferedImage;
    }
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
