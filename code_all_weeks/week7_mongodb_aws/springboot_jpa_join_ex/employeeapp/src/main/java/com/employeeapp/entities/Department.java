package com.employeeapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

//Anti curruption pattern in rest
//Entity --> controller
//entity --> dto --> send to the user
//dto-> entity -> service layer

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"employees"})
@Entity
@Table(name="dept_table")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int did;
	private String dname;

	//@JsonIgnore
	@JsonManagedReference
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL,
			fetch = FetchType.EAGER)
	private List<Employee> employees=new ArrayList<>();

	public Department(String dname) {
		this.dname = dname;
	}
}