package tw.leonchen.action;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.leonchen.model.Person;

public class DemoPersonAction {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		
		Person person1=context.getBean("person1", Person.class);
		System.out.println(person1.getId()+" "+person1.getName()+" "+person1.getAge());
	
		Person person2 = context.getBean("person2", Person.class);
		System.out.println("Date:" + person2.getDate());

		Person person3 = context.getBean("person3", Person.class);
		System.out.println(person3.getId()+" "+person3.getName()+" "+person3.getAge()+" "+person3.getDate());
		
		context.close();
	}

}
