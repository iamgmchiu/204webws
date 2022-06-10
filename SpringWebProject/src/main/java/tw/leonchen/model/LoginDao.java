package tw.leonchen.model;

public class LoginDao {
public boolean checkLogin(String user,String pwd) {
	if ("john".equals(user)&& "test123".equals(pwd)) {
		return true;
	}
	return false;
}
}
