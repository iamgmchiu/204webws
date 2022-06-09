package tw.leonchen.action;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.leonchen.model.WorkerService;

public class DemoWorkerAction {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beans.config.xml");
	WorkerService wService	=context.getBean("wService", WorkerService.class);
		wService.printDetails();
		
		
		context.close();
	}

}
