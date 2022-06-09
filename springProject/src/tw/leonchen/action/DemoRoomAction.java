package tw.leonchen.action;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import tw.leonchen.config.SpringJavaConfig;
import tw.leonchen.model.Room;

public class DemoRoomAction {

	public static void main(String[] args) {
	AnnotationConfigApplicationContext context	=new AnnotationConfigApplicationContext(SpringJavaConfig.class);
	Room room1=context.getBean("room1", Room.class);

	System.out.println(room1.getId()+" "+room1.getName()+" "+room1.getSize());
	
	context.close();
	}
}
