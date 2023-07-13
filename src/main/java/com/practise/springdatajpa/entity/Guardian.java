package com.practise.springdatajpa.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
//Used to set the names of the column in which this class is going to be Embedded.
//It takes List as a parameter hence the --> {} inside.
@AttributeOverrides({
	//used to override the Attributes one-by-one 
	@AttributeOverride(
			name = "name",
			column = @Column(name="guardian_name")
			),
	@AttributeOverride(
			name = "email",
			column = @Column(name="guardian_email")
			),
	@AttributeOverride(
			name="mobile",
			column=@Column(name="guardian_mobile")
			)
	
})
public class Guardian {

	private String name;	
	private String email;
	private String mobile;

}
