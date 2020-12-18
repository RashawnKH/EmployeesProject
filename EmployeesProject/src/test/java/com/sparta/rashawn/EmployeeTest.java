package com.sparta.rashawn;


import com.sparta.rashawn.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class EmployeeTest {



    @Test
    public void checkSetID(){
        Employee employee = new Employee();

        employee.setCmp_ID("WTA1");
        Assertions.assertEquals("WTA1",employee.getCmp_ID());

    }


    @Test
    public void checkSetNamePrefix(){
        Employee employee = new Employee();

        employee.setNamePrefix("Mr.");
        Assertions.assertEquals("Mr.",employee.getNamePrefix());

    }


    @Test
    public void checkSetFirstName(){
        Employee employee = new Employee();

        employee.setFirstName("Rashawn");
        Assertions.assertEquals("Rashawn",employee.getFirstName());

    }


    @Test
    public void checkSetMiddleInitial(){
        Employee employee = new Employee();

        employee.setMiddleInitial("K");
        Assertions.assertEquals("K",employee.getMiddleInitial());

    }


    @Test
    public void checkSetLastName(){
        Employee employee = new Employee();

        employee.setLastName("Henry");
        Assertions.assertEquals("Henry",employee.getLastName());

    }


    @Test
    public void checkSetGender(){
        Employee employee = new Employee();

        employee.setGender("M");
        Assertions.assertEquals("M",employee.getGender());

    }


    @Test
    public void checkSetDOB(){
        Employee employee = new Employee();
        LocalDate date = LocalDate.of(1999,06,17);
        employee.setDateOfBirth("06/17/1999");
        Assertions.assertEquals(date,employee.getDateOfBirth());

    }


    @Test
    public void checkSetDOJ(){
        Employee employee = new Employee();
        LocalDate date = LocalDate.of(2020,06,17);
        employee.setDateOfJoin("06/17/2020");
        Assertions.assertEquals(date,employee.getDateOfJoin());

    }


    @Test
    public void checkSetSalary(){
        Employee employee = new Employee();

        employee.setSalary("1000000");
        Assertions.assertEquals(1000000,employee.getSalary());

    }


    @Test
    public void checkSetEmail(){
        Employee employee = new Employee();

        employee.setEmail("exampleemail@email.com");
        Assertions.assertEquals("exampleemail@email.com",employee.getEmail());

    }












}
