package com.sparta.rashawn;

import com.sparta.rashawn.controller.EmployeeRepository;
import com.sparta.rashawn.model.Employee;
import com.sparta.rashawn.model.EmployeeDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class EmployeeDAOTest {


    @Test
    public void checkCanInsert(){
       ArrayList<Employee> employees = EmployeeRepository.getEmployees();
       ArrayList<Employee> cleanList = EmployeeRepository.generatedCleanList(employees);
       ArrayList<Employee> employeesFromDB;

       EmployeeDAO employeeDAO = new EmployeeDAO();

        employeesFromDB = employeeDAO.queryDatabase("SELECT * FROM employeedb.test_db", EmployeeDAO.connectToDB("jdbc:mysql://localhost:3306/employeedb"));

        Assertions.assertEquals(cleanList.size() , employeesFromDB.size());
        for (int i = 0; i<cleanList.size(); i++){
            Assertions.assertEquals(cleanList.get(i).toString(), employeesFromDB.get(i).toString());
        }
    }

}
