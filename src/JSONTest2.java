/*
 * How to use Jackson annotation @JsonProperty and @JsonIgnore
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

class Employee {
	// private field is not visible by Jackson. 
	// Supply with @JsonProperty with same name or add a public getter method
	@JsonProperty("name") 
	private String name;

	// mapping JSON property name with field name
	@JsonProperty("emp_id")
	private int empId;

	// properties that you do not want to write out
	@JsonIgnore
    private String department;
	
	public Employee() {} // Add a default constructor for each class you used as a mapping class
	
	public Employee(String name, int empId, String dept) {
		this.name = name;
		this.empId = empId;
		this.department = dept;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", empId=" + empId + ", department="
				+ department + "]";
	}

}

public class JSONTest2 {

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();

		// JOSN to Plain Old Java Object ("POJO")
		try {
			Employee emp1 = mapper.readValue("{\"name\":\"Bob\", \"emp_id\":1}", Employee.class);
			System.out.println(emp1);

		} catch (Exception e) {
			e.printStackTrace();
		}

		// POJO to JOSN
		Employee emp2 = new Employee("emp2", 2, "IT");
		try {
			// convert user object to json string, and display to console
			System.out.println(mapper.writeValueAsString(emp2));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
