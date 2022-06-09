package tw.leonchen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tw.leonchen.model.Room;

@Configuration
public class SpringJavaConfig {
	
	@Bean   //<bean id="room1" class="tw.leonchen.model.Room"/>
	public Room room1() {
		Room r1 = new Room();
		r1.setId(1);
		r1.setName("living room");
		r1.setSize("medium");
		return r1;
	}

}
