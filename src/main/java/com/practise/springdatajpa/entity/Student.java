package com.practise.springdatajpa.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(
		//change the name of the table 
		name = "student_tbl",
		//add unique constraints to the specified columns
		uniqueConstraints = @UniqueConstraint(
			name="email_id_unique",
			columnNames = "email_address"
		)	
)
@Builder
public class Student {
	
	//Makes the field as the primary key of the table
	@Id
	//Creates a Sequence-Generator with specified name,sequenceName and allocation Size
	@SequenceGenerator(
			name = "student_squence",
			sequenceName = "student_squence",
			allocationSize = 1
	)
	//Add Sequence Generator
	@GeneratedValue(	
			strategy = GenerationType.SEQUENCE,
			generator = "student_squence"
	)
	
	private Long studentId;
	
	private String firstName;
	private String middleName;
	private String lastName;
	
	@Column(
			name="email_address",
			nullable = false
	)
	private String emailId;
	
	
	/*
	  Adds or Embeds Guardian Class in the same table 
	  i.e. adds the guardian fields in the same table
	 */
	@Embedded
	private Guardian guardian;
	

}
