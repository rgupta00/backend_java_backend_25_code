package com.empapp.dao.impl;

import com.empapp.dao.Employee;
import com.empapp.dao.EmployeeDao;
import com.empapp.exceptions.DaoException;
import com.empapp.factory.ConnectionFactory;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class EmployeeDaoJdbcImpl implements EmployeeDao {
    private Connection connection;

    public EmployeeDaoJdbcImpl() {
        connection= ConnectionFactory.getConnection();
    }
    @Override
    public List<Employee> allEmp()  {
        System.out.println("-----------using jdbc------------");
        List<Employee> employees=new LinkedList<>();
        try {
            PreparedStatement pstmt=connection.prepareStatement("select * from emp");
            ResultSet rs=pstmt.executeQuery();
            while (rs.next()){
                employees.add(new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("salary")));
            }
        } catch (SQLException e) {
            throw new DaoException("some dao ex while using jdbc", e);// ex wrapping and rethrowing!
        }
        return employees;
    }

    @Override
    public Employee getEmpById(int id) {
        Employee employee=null;
        try {
            PreparedStatement preparedStatement=connection
                    .prepareStatement("select * from emp where id=?");
            preparedStatement.setInt(1,id);

            ResultSet rs=preparedStatement.executeQuery();
            if (rs.next()){
                employee=new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("salary")) ;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employee;
    }

    @Override
    public Employee addEmp(Employee employee) {
        try {
            PreparedStatement preparedStatement=connection
                    .prepareStatement("insert into emp(name, salary) values(?,?)" ,
                            Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1,employee.getName());
            preparedStatement.setInt(2,employee.getSalary());

           preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            if(rs.next()) {
                employee.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employee;
    }

    @Override
    public void updateEmp(int id, Employee employee) {
        try {
           PreparedStatement preparedStatement=connection
                    .prepareStatement("update emp set salary=? where id=?");
            preparedStatement.setInt(1,employee.getSalary());
            preparedStatement.setInt(2,id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEmp(int id) {
        try {
            PreparedStatement preparedStatement=connection
                    .prepareStatement("delete from emp where id=?");
            preparedStatement.setInt(1,id);

           preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
