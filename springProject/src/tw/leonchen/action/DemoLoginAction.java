package tw.leonchen.action;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.leonchen.model.LoginDao;
import tw.leonchen.model.LoginService;

public class DemoLoginAction {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		LoginDao loginDao=context.getBean("loginDao",LoginDao.class);
		boolean status1=loginDao.checkLogin("john", "test123");
		System.out.println("status1:"+status1);
		
		
		LoginService loginService1=context.getBean("loginService1",LoginService.class);
		boolean status2=loginService1.checkLogin("mary", "12345");
		System.out.println("status2:"+status2);
		
		LoginService loginService2 = context.getBean("loginService2", LoginService.class);
		boolean status3 = loginService2.checkLogin("john", "test123");
		System.out.println("status3:" + status3);
		
		context.close();
	}

}
