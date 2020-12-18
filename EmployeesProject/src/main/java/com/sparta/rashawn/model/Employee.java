package com.sparta.rashawn.model;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Employee {

    //Object types map cleaner to SQL values
    String cmp_ID;
    String namePrefix;
    String firstName;
    String middleInitial;
    String lastName;
    String gender;
    String email;
    LocalDate dateOfBirth;
    LocalDate dateOfJoin;
    Integer salary;

    public Employee(String cmp_ID, String namePrefix, String firstName, String middleInitial, String lastName, String gender, String email, String dateOfBirth, String dateOfJoin, String salary) {
        this.cmp_ID = cmp_ID;
        this.namePrefix = namePrefix;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        setDateOfBirth(dateOfBirth);
        setDateOfJoin(dateOfJoin);
        setSalary(salary);
    }


    public  Employee(){

    }


    public String getCmp_ID() {
        return cmp_ID;
    }

    public void setCmp_ID(String cmp_ID) {
        this.cmp_ID = cmp_ID;
    }

    public String getNamePrefix() {
        return namePrefix;
    }

    public void setNamePrefix(String namePrefix) {
        this.namePrefix = namePrefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("M[M]/d[d]/yyyy"));
    }
    public LocalDate getDateOfJoin() {
        return dateOfJoin;
    }

    public void setDateOfJoin(String dateOfJoin) {
        LocalDate date = LocalDate.parse(dateOfJoin, DateTimeFormatter.ofPattern("M[M]/d[d]/yyyy"));
        this.dateOfJoin = date;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = Integer.valueOf(salary);
    }


    @Override
    public String toString() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        return
                getCmp_ID()+ ',' +
                getNamePrefix()+','+
                getFirstName()+','+
               getMiddleInitial()+','+
                getLastName()+','+
                getGender()+','+
                getEmail()+','+
                dateOfBirth.format(formatter)+','+
                dateOfJoin.format(formatter)+','+
                getSalary();
    }
}
