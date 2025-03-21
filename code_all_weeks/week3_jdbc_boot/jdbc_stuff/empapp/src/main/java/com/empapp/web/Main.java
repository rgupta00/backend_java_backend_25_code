package com.empapp.web;

import com.empapp.dao.Employee;
import com.empapp.exceptions.DaoException;
import com.empapp.service.EmployeeService;
import com.empapp.service.EmployeeServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeService employeeService=new EmployeeServiceImpl();
        System.out.println("All employees are ");
      try{
          List<Employee> employees = employeeService.allEmp();
          for(Employee e: employees){
              System.out.println(e);
          }
      }catch (DaoException e){
          System.out.println(e.getMessage());
          System.out.println(e.getCause());
      }


    }
}
