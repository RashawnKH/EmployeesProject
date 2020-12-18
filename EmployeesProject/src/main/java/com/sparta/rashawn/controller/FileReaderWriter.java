package com.sparta.rashawn.controller;

import com.sparta.rashawn.model.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class FileReaderWriter {
    private static Logger logger = LogManager.getLogger(FileReaderWriter.class);

    public static ArrayList<Employee> readEmployees(String path){

        logger.info("Reading employees...");


        ArrayList<Employee> employees = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            String[] arrayOfStrings;
            bufferedReader.readLine();
            while((line = bufferedReader.readLine())!=null){
                arrayOfStrings = line.split(",");
                employees.add(EmployeeRepository.generateEmployee(arrayOfStrings));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        if (employees.size() == 0){
            System.out.println("Please enter a file with records, the file entered is empty");
            return employees;
        }

        logger.info("Employees read");

        return employees;
    }

    public static void writeErrorsToFile(ArrayList<Employee> employees){

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("duplicates.txt"))) {

            bufferedWriter.write("Emp ID,Name Prefix,First Name,Middle Initial,Last Name,Gender,E Mail,Date of Birth,Date of Joining,Salary");
            bufferedWriter.newLine();
            for (Employee employee : employees) {
                bufferedWriter.write(employee.toString());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}
