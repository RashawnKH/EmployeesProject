package com.sparta.rashawn.view;

import com.sparta.rashawn.controller.GenerateThreads;
import com.sparta.rashawn.model.Employee;
import com.sparta.rashawn.controller.EmployeeRepository;

import java.util.ArrayList;

public class Display {
    private static ArrayList<Employee> readInFromCSV;
    private static ArrayList<Employee> cleanList;


    public static void displayTimeTakenToLoadFile(){
        System.out.println("Loading file...");

        long start = System.nanoTime();
        readInFromCSV = EmployeeRepository.getEmployees();
        long finish = System.nanoTime();
        long total = (finish - start) / 1_000_000_000;
        System.out.println("Time taken to read in the file: " + total);


    }

    public static void displayTimeTakenToCheckErrors(){
        System.out.println("Checking for errors");

        long start = System.nanoTime();
        cleanList = EmployeeRepository.generatedCleanList(readInFromCSV);
        long finish = System.nanoTime();
        long total = (finish - start) / 1_000_000_000;
        System.out.println("Time taken to find and remove duplicates: " + total);
    }

    public static void displayTimeTakenToInsert(){
        System.out.println("Inserting data into the database...");

        GenerateThreads generateThreads = new GenerateThreads();
        generateThreads.runThreads(cleanList);

        long start = System.nanoTime();
        for (Thread thread : generateThreads.getThreads()){
            while (thread.isAlive());
        }
        long finish = System.nanoTime();
        long total = (finish - start) / 1_000_000_000;
        System.out.println("Data inserted");
        System.out.println("Time taken to insert into the database is: " + total);
    }



}
