package com.practise.springdatajpa;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.practise.springdatajpa.entity.Guardian;
import com.practise.springdatajpa.entity.Student;
import com.practise.springdatajpa.repositories.StudentRepo;

@SpringBootTest
class SpringDataJpaApplicationTests {
	@Autowired
	StudentRepo studentRepo;

	@Disabled
	@Test
	void contextLoads() {
		Student student = Student.builder()
				.firstName("Pratik")
				.middleName("G")
				.lastName("Musmade")
				.emailId("pratik@gmail.com")
//				.guardianEmail("guard@gmail.com")
//				.guardianMobile("1234567890")
//				.guardianName("Pratik")
				.build();
		studentRepo.save(student);
		System.out.println(student);
	}
	
	@Disabled
	@Test
	void saveStudets() {
	Student student2 = Student.builder()
			.firstName("Aditya")
			.middleName("G")
			.lastName("Sathe")
			.emailId("adi@gmail.com")
//			.guardianEmail("guard@gmail.com")
//			.guardianMobile("1234567890")
//			.guardianName("Pratik")
			.build();
	studentRepo.save(student2);
	System.out.println(student2);
	}
	
	@Test
	void saveStudentGuardian() {
		Guardian guardian = Guardian.builder()
				.name("Pratik")
				.email("pratik@gmail.com")
				.mobile("1234567890")
				.build();
		Student student = Student.builder()
				.firstName("Aditya")
				.middleName("G")
				.lastName("Sathe")
				.emailId("adi@gmail.com")
				.guardian(guardian)
				.build();
		studentRepo.save(student);
		
	}
}
