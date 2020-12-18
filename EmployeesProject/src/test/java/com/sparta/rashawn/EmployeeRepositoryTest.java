package com.sparta.rashawn;

import com.sparta.rashawn.model.Employee;
import com.sparta.rashawn.controller.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class EmployeeRepositoryTest {


    @Test
    public void checkDuplicatesAreRemoved(){

        ArrayList<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee();
        employee1.setCmp_ID("01");

        Employee employee2 = new Employee();
        employee2.setCmp_ID("01");

        Employee employee3 = new Employee();
        employee3.setCmp_ID("02");

        Employee employee4 = new Employee();
        employee4.setCmp_ID("03");

        Employee employee5 = new Employee();
        employee5.setCmp_ID("04");

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);

        ArrayList<Employee> cleanList = EmployeeRepository.generatedCleanList(employees);


        Assertions.assertTrue(!cleanList.contains(employee1) && !cleanList.contains(employee2));
        Assertions.assertTrue(cleanList.contains(employee3) && cleanList.contains(employee4) && cleanList.contains(employee5));

    }



    @Test
    public void checkDuplicatesIDsAreCaught(){

        ArrayList<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee();
        employee1.setCmp_ID("01");

        Employee employee2 = new Employee();
        employee2.setCmp_ID("01");

        Employee employee3 = new Employee();
        employee3.setCmp_ID("02");

        Employee employee4 = new Employee();
        employee4.setCmp_ID("03");

        Employee employee5 = new Employee();
        employee5.setCmp_ID("04");

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);

        ArrayList<Employee> duplicates = EmployeeRepository.getDuplicates(employees);


        Assertions.assertTrue(duplicates.contains(employee1) && duplicates.contains(employee2));

    }





}




