package com.practise.springdatajpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.practise.springdatajpa.entity.Student;
import com.practise.springdatajpa.repositories.StudentRepo;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

	@Autowired
	StudentRepo studentRepo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Student student = Student.builder()
							.firstName("Pratik")
							.middleName("G")
							.lastName("Musmade")
							.emailId("pratik@gmail.com")
//							.guardianEmail("guard@gmail.com")
//							.guardianMobile("1234567890")
//							.guardianName("Pratik")
							.build();
		Student student2 = Student.builder()
				.firstName("Aditya")
				.middleName("G")
				.lastName("Sathe")
				.emailId("adi@gmail.com")
//				.guardianEmail("guard@gmail.com")
//				.guardianMobile("1234567890")
//				.guardianName("Pratik")
				.build();
		//studentRepo.save(student2);
		
		//List<Student> stud = studentRepo.findAll();
		//System.out.println(stud);
		
//		studentRepo.save(student);
	}

}
