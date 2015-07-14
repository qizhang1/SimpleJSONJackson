/*
 * How to convert Java object to / from JSON (Jackson)
 */
import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

class Person {
	public String name;
	public int age;

	public Person() {} // Add a default constructor for each class you used as a mapping class
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}

public class JSONTest1 {

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();

		// JOSN to Plain Old Java Object ("POJO")
		try {
			Person p1 = mapper.readValue(new File("data.json"), Person.class);
			System.out.println(p1);

		} catch (Exception e) {
			e.printStackTrace();
		}

		// POJO to JOSN
		Person p2 = new Person("p2", 2);
		try {
			// convert user object to json string, and save to a file
			mapper.writeValue(new File("user.json"), p2);

			// display to console
			System.out.println(mapper.writeValueAsString(p2));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
