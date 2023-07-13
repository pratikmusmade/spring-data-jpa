package com.practise.springdatajpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practise.springdatajpa.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

}
