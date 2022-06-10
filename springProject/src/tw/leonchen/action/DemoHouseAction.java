package tw.leonchen.action;

import java.sql.SQLException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.leonchen.model.House;
import tw.leonchen.model.HouseService;

public class DemoHouseAction {

	public static void main(String[] args) throws SQLException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");

		HouseService houseService = context.getBean("houseService", HouseService.class);
		House resultBean = houseService.findById(1);
		
		if (resultBean != null) {
			System.out.println(resultBean.getHouseid() + " " + resultBean.getHousename());
		}else {
			System.out.println("no result");
		}

		context.close();
	}

}
