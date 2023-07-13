package com.practise.springdatajpa.repositories;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.practise.springdatajpa.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

	//Using the existing className combinations in JPA to get data by firstName
	Student findByFirstName(String firstName);
	List<Student> findByFirstNameContaining(String firstName);
	
	//Accessing data using JPQL
	@Query("select s.id from Student s where firstName = :name")
	long getIdByFirstName(@Param("name") String name);
	
	
	//Updating the Data using Native Query 
	//To Update we have to use @Modifying 
	//@Transactional is used to initiate the translation
	@Modifying
	@Transactional
	@Query(
			value = "update student_tbl set first_name = :firstName where email_address = :email",
			nativeQuery = true
			)
	int updateFirstNameByEmail(@Param("firstName") String firstName,@Param("email") String email);
	
	//Native Query
	@Query(
			value="select * from student_tbl s where s.last_name = :lastName",
			nativeQuery = true
		  )
	List<Student> fetchStudentsByLastName(@Param("lastName") String lastName);
}
