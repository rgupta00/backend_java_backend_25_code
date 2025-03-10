package com.employeeapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"employees"})

@Entity
@Table(name="p_table")
public class Project {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;

	private String pname;
	private String manager;
	private LocalDate startDate;

	@JoinTable(name="emp_project_join", joinColumns = @JoinColumn(name="pid_fk"),
			inverseJoinColumns = @JoinColumn(name="eid_fk"))
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Employee> employees=new ArrayList<>();

	public Project(String pname, String manager, LocalDate startDate) {
		this.pname = pname;
		this.manager = manager;
		this.startDate = startDate;
	}
}
