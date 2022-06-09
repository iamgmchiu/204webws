import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
public class LoginedUser implements HttpSessionBindingListener
{
  String userId = null;
  String userPasswd = null;
  Date startTime = null;
  Date endTime = null;
  
  public LoginedUser()
  {
  }
  public LoginedUser(String pUserId, String pUserPasswd)
  {
    userId = pUserId  ;
    userPasswd = pUserPasswd;
  }
  public String toString()
  {
    String userInfo = "UserId:" + userId + "  " + "UserPasswd:" + userPasswd;
    return (userInfo);
  }
  
  public void valueBound(HttpSessionBindingEvent hsbe)
  {
    startTime = new Date();
    System.out.println("LoginedUser Information : " + this.toString());
    hsbe.getSession().getServletContext().log("LoginedUser Information : " + this.toString());
  }

  public void valueUnbound(HttpSessionBindingEvent hsbe)
  {
    endTime = new Date();
    System.out.println("LogoutUser Information : " + this.toString() + "  " +  
                      "Session Duration:" + (endTime.getTime() - startTime.getTime()) + " (ms)");
    hsbe.getSession().getServletContext().log("Logout Information : " + this.toString()+ "  " + 
                      "Session Duration:" + (endTime.getTime() - startTime.getTime()) + " (ms)");    
  }
}