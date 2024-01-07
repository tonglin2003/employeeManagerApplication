package com.practice.employeemanager;

import com.practice.employeemanager.model.Employee;
import com.practice.repository.EmployeeRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;



import java.util.List;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableMongoRepositories(basePackages = "com.practice.repository")
@ComponentScan(basePackages = "com.practice")
public class EmployeemanagerApplication implements CommandLineRunner {

	@Autowired
	EmployeeRepo employeeRepo;

	public static void main(String[] args){
		SpringApplication.run(EmployeemanagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		System.out.println("Spring Boot application has started!");
//		System.out.println("Spring Boot application has started!");
//
//		System.out.println("\n-----CREATE EMPLOYEES-----\n");
//		 // createEmployees();
//
//		System.out.println("\n-----GET EMPLOYEE BY NAME-----\n");
////		getEmployeeByName("John Doe");
//		getAllEmployee();
//
//		System.out.println("\n-----GET EMPLOYEES BY JOB TITLE-----\n");
//		getEmployeesByJobTitle("Manager");
//
//		System.out.println("\n-----UPDATE JOB TITLE-----\n");
//		updateJobTitle("Manager", "Alice Smith");
//
//		System.out.println("\n-----DELETE EMPLOYEE-----\n");
//		//deleteEmployee("EMP003");
//
//		System.out.println("\n-----THANK YOU-----");
	}


	// ----------- CRUD OPERATION ----------- //


	// CREATE
	void createEmployees(){
		System.out.println("Data creation started...");
		employeeRepo.save(new Employee("John Doe", "john@example.com", "Manager", "+1-123-456-7890", "img1.jpg", "EMP001"));
		employeeRepo.save(new Employee("Alice Smith", "alice@example.com", "Developer", "+1-234-567-8901", "img2.jpg", "EMP002"));
		employeeRepo.save(new Employee("Bob Johnson", "bob@example.com", "Designer", "+1-345-678-9012", "img3.jpg", "EMP003"));
		employeeRepo.save(new Employee("Eva Brown", "eva@example.com", "Analyst", "+1-456-789-0123", "img4.jpg", "EMP004"));
		employeeRepo.save(new Employee("Chris Wilson", "chris@example.com", "Tester", "+1-567-890-1234", "img5.jpg", "EMP005"));
		System.out.println("Data creation ENDED!!!!!!!!!!!!!!!!!!!!!!!!!!!");

	}

	// READ
	public void getEmployeeByName(String name){
		System.out.println("Getting employee by name: " + name);
		Employee em = employeeRepo.findEmployeeByName(name);
		System.out.println(em);

	}

	public void getEmployeesByJobTitle(String jobTitle){

		System.out.println("Getting items for the category " + jobTitle);
		List<Employee> list = employeeRepo.findAllJobTitle(jobTitle);
		list.forEach(item -> System.out.println("Name: " + item.getName()));

	}

	public void getAllEmployee(){
		System.out.println("Printing out all of the employee...");
		List<Employee> list = employeeRepo.findAll();

		list.forEach(item -> {
			System.out.println("testing,,,,");
			System.out.println("Name: " + item.getName());
		});
	}


	// UPDATE
	public void updateJobTitle(String newJobTitle, String name){

		Employee em = employeeRepo.findEmployeeByName(name);

		em.setJobTitle(newJobTitle);

		Employee employeeUpdated = employeeRepo.save(em);

		System.out.println("Successfully updated, " + employeeUpdated.getName() + ", just became " + employeeUpdated.getJobTitle());

	}


	// DELETE
	public void deleteEmployee(String employeeCode){

		Employee deleteEm = employeeRepo.findEmployeeByEmployeeCode(employeeCode);

		ObjectId idNum = deleteEm.getId();
		employeeRepo.deleteById(idNum);
	}


}
