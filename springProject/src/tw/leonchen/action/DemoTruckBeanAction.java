package tw.leonchen.action;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.leonchen.model.TruckBean;

public class DemoTruckBeanAction {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		
		TruckBean nissanTruck=context.getBean("nissanTruck", TruckBean.class);
		System.out.println(nissanTruck.getId()+" "+nissanTruck.getBrand());
		
		TruckBean benzTruck = context.getBean("benzTruck", TruckBean.class);
		System.out.println(benzTruck.getId() + " " + benzTruck.getBrand());
		
		
		context.close();
	}

}
