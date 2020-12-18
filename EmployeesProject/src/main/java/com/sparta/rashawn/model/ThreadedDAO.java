package com.sparta.rashawn.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ThreadedDAO implements Runnable{
    private static Logger logger = LogManager.getLogger(ThreadedDAO.class);


    private List<Employee> employees;

    public ThreadedDAO(List<Employee> employees){
            this.employees = employees;
    }

    @Override
    public void run() {
        logger.info("Inserting data into the database");
        String url = "jdbc:mysql://localhost:3306/employeedb";
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.setUrl(url);
        employeeDAO.insertData(employees, EmployeeDAO.connectToDB(employeeDAO.getUrl()));
        logger.info("Data Inserted");
      }
    }



