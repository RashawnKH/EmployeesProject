package com.sparta.rashawn;

import com.sparta.rashawn.controller.FileReaderWriter;
import com.sparta.rashawn.controller.EmployeeRepository;
import com.sparta.rashawn.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class FileReaderWriterTest {

    @Test
    public void checkCanWriteToFile(){

        ArrayList<Employee> employees = EmployeeRepository.getEmployees();
        ArrayList<Employee> duplicates = EmployeeRepository.getDuplicates(employees);

        FileReaderWriter.writeErrorsToFile(duplicates);
        ArrayList<Employee> duplicatesFromFile = FileReaderWriter.readEmployees("duplicates.txt");

        for (int i = 0; i<duplicates.size(); i++){
            Assertions.assertEquals(duplicatesFromFile.get(i).toString(),duplicates.get(i).toString());
        }

    }

    @Test
    public void checkCanReadCSVFile() {
        ArrayList<Employee> employees = EmployeeRepository.getEmployees();

        Employee employee2 = new Employee("198429", "Mrs.", "Serafina", "I", "Bumgarner", "F", "serafina.bumgarner@exxonmobil.com", "9/21/1982", "2/1/2008", "69294");
        Employee employee1 = new Employee("178566", "Mrs.", "Juliette", "M", "Rojo", "F", "juliette.rojo@yahoo.co.uk", "5/8/1967", "6/4/2011", "193912");
        Employee employee4 = new Employee("647173", "Mr.", "Milan", "F", "Krawczyk", "M", "milan.krawczyk@hotmail.com", "4/4/1980", "1/19/2012", "123681");
        Employee employee5 = new Employee("847634", "Mr.", "Elmer", "R", "Jason", "M", "elmer.jason@yahoo.com", "4/9/1996", "5/28/2017", "93504");
        Employee employee3 = new Employee("260736", "Ms.", "Zelda", "P", "Forest", "F", "zelda.forest@ibm.com", "11/27/1959", "1/28/2014", "176642");

        ArrayList<Employee> employeesToCompare = new ArrayList<>();
        employeesToCompare.add(employee1);
        employeesToCompare.add(employee2);
        employeesToCompare.add(employee3);
        employeesToCompare.add(employee4);
        employeesToCompare.add(employee5);

        Assertions.assertEquals(employeesToCompare.size() , employees.size());

        for (int i = 0; i< employeesToCompare.size(); i++) {
            Assertions.assertEquals(employeesToCompare.get(i).toString(),employees.get(i).toString());
        }
    }


    @Test
    public void checkForBlankFile(){
        ArrayList<Employee> blanklist = FileReaderWriter.readEmployees("src/main/resources/BlankTest.csv");
        Assertions.assertEquals(0,blanklist.size());

    }



}
