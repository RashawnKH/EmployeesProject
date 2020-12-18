package com.sparta.rashawn.controller;

import com.sparta.rashawn.model.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;


public class EmployeeRepository {

    private static Logger logger = LogManager.getLogger(EmployeeRepository.class);


    public static ArrayList<Employee> getEmployees(){
        ArrayList<Employee> employees =  FileReaderWriter.readEmployees("src/main/resources/EmployeeRecords.csv");
        return  employees;
    }

    public static ArrayList<Employee> getDuplicates(ArrayList<Employee> employees){
        logger.info("Checking for duplicates");

        ArrayList<Employee> employeesDuplicates = new ArrayList<>();
        for (Employee employee: employees) {
            for (Employee e: employees){
                if (employee.getCmp_ID().equals(e.getCmp_ID()) && employee != e){
                    employeesDuplicates.add(employee);
                }
            }
        }
        logger.info("Duplicates found: "+ employeesDuplicates.size());
        return  employeesDuplicates;
    }


    public static ArrayList<Employee> generatedCleanList(ArrayList<Employee> employees){
        ArrayList<Employee> duplicateList = getDuplicates(employees);
        logger.info("Removing duplicates...");
        employees.removeAll(duplicateList);
        logger.info("Duplicates Removed");

        return employees;
    }


    public static Employee generateEmployee(String[] arrayOfStrings)  {


        Employee employee = new Employee();
        employee.setCmp_ID(arrayOfStrings[0]);
        employee.setNamePrefix(arrayOfStrings[1]);
        employee.setFirstName(arrayOfStrings[2]);
        employee.setMiddleInitial(arrayOfStrings[3]);
        employee.setLastName(arrayOfStrings[4]);
        employee.setGender(arrayOfStrings[5]);
        employee.setEmail(arrayOfStrings[6]);
        employee.setDateOfBirth(arrayOfStrings[7]);
        employee.setDateOfJoin(arrayOfStrings[8]);
        employee.setSalary(arrayOfStrings[9]);
        return employee;
    }


}
