package com.practise.springdatajpa;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.practise.springdatajpa.entity.Guardian;
import com.practise.springdatajpa.entity.Student;
import com.practise.springdatajpa.repositories.StudentRepo;

@SpringBootTest
class SpringDataJpaApplicationTests {
	
	//FIXME : Test Cases written in Sloppy Manner
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
	
	@Disabled
	@Test
	void saveStudentGuardian() {
		
		Guardian guardian = Guardian.builder()
				.name("Pratik")
				.email("pratik@gmail.com")
				.mobile("1234567890")
				.build();
		
		
		Student student = Student.builder()
				.firstName("Vikrant")
				.middleName("K")
				.lastName("Kharos")
				.emailId("khro@gmail.com")
				.guardian(guardian)
				.build();
		
		Student student2 = Student.builder()
				.firstName("Aniket")
				.middleName("G")
				.lastName("Joshi")
				.emailId("josh@gmail.com")
				.guardian(guardian)
				.build();
		
		studentRepo.save(student);
		studentRepo.save(student2);

	}

	@Disabled
	@Test
	void findStudetByFirstName() {
		Student s1 = studentRepo.findByFirstName("Pratik");
		System.out.println(s1);
	}
	
	@Disabled
	@Test
	void findStudentByContaingFirstName() {
		System.out.println(studentRepo.findByFirstNameContaining("A"));
	}
	
	@Disabled
	@Test
	void updateStudentName() {
		//long id = studentRepo.getIdByFirstName("Aniket");
		//System.out.println(id);
		Guardian g = Guardian.builder()
				.email("pra@gmail.com")
				.name("Lakshman")
				.mobile("7894561235")
				.build();
		
		
		Student student = studentRepo.findByFirstName("Aniket");
		student.setLastName("JOSHI");
		student.setGuardian(g);
		
		studentRepo.save(student);
	}
	
	@Test
	void updateEmailAddress() {
		int s = studentRepo.updateFirstNameByEmail("BHIRAVaditya","adi@gmail.com");
		System.out.println(s);
	}
	
	@Disabled
	@Test
	void fetchStudentsByLastName() {
		List<Student> stu = studentRepo.fetchStudentsByLastName("Sathe"); 
		System.out.println(stu);
	}
	
}
