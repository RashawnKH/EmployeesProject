package com.sparta.rashawn.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EmployeeDAO {


    private static Connection connection;
    private static Properties properties = new Properties();
    private static Logger logger = LogManager.getLogger(EmployeeDAO.class);
    private String url;

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private static void createProperties(){
        try {
            properties.load(new FileReader("src/main/resources/login.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection connectToDB(String url){
        createProperties();
        String username = properties.getProperty("userName");
        String password = properties.getProperty("password");
        try {

             connection = DriverManager.getConnection(url, username, password);
             logger.info("Connected to Database");

        } catch (SQLException throwables) {
            System.out.println("Could not establish Database connection.");
            System.out.println("Please ensure that either the url,username or password provided are correct.");
            System.exit(-1);
        }

        return connection;
    }

    public ArrayList<Employee> queryDatabase(String query, Connection connection) {
        ArrayList<Employee> employeesFromDB = new ArrayList<>();

        try {
            this.connection = connection;
            Statement statement = connection.createStatement();
            ResultSet resultSet =  statement.executeQuery(query);

            while (resultSet.next()){
                Employee employee = new Employee();
                employee.setCmp_ID(resultSet.getString(1));
                employee.setNamePrefix(resultSet.getString(2));
                employee.setFirstName(resultSet.getString(3));
                employee.setMiddleInitial(resultSet.getString(4));
                employee.setLastName(resultSet.getString(5));
                employee.setGender(resultSet.getString(6));
                employee.setEmail(resultSet.getString(7));

                LocalDate dob = resultSet.getDate(8).toLocalDate();
                LocalDate doj = resultSet.getDate(9).toLocalDate();
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

                employee.setDateOfBirth(dob.format(dateFormatter));
                employee.setDateOfJoin(doj.format(dateFormatter));
                employee.setSalary(String.valueOf(resultSet.getInt(10)));
                employeesFromDB.add(employee);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return employeesFromDB;
    }



  public static void insertData(List<Employee> employees, Connection connection)  {

      PreparedStatement  preparedStatement = null;
      try {
          preparedStatement = connection.prepareStatement("INSERT INTO `employeedb`.`employees` (`emp_id`,`name_prefix`,`first_name`, `middle_initial`, `last_name`, `gender`, `email`,`date_of_birth`, `date_of_join`, `salary`)" +
                  "values( ?,?,?,?,?,?,?,?,?,?)");
      } catch (SQLException throwables) {
          throwables.printStackTrace();
      }
              PreparedStatement finalPreparedStatement = preparedStatement;
              employees.forEach(e -> {
                  try {
                      Date dob = Date.valueOf(e.getDateOfBirth());
                      Date doj = Date.valueOf(e.getDateOfJoin());
                      finalPreparedStatement.setString(1,e.getCmp_ID());
                      finalPreparedStatement.setString(2, e.getNamePrefix());
                      finalPreparedStatement.setString(3, e.getFirstName());
                      finalPreparedStatement.setString(4, e.getMiddleInitial());
                      finalPreparedStatement.setString(5, e.getLastName());
                      finalPreparedStatement.setString(6, e.getGender());
                      finalPreparedStatement.setString(7, e.getEmail());
                      finalPreparedStatement.setDate(8, dob);
                      finalPreparedStatement.setDate(9, doj);
                      finalPreparedStatement.setInt(10, e.getSalary());
                      finalPreparedStatement.execute();

                  } catch (SQLException throwables) {
                      throwables.printStackTrace();
                  }
              });


           }

  }


