package com.kamarbaraka.practice;

import java.util.*;

/**
 * a simple java program to store staff information of a company.
 * the staff object stores the number and information of {@link Employee}s in the company.
 * the staff object has methods {@code  add()}, {@code get()} and {@code  getStaff()}.
 * the add method takes an employee object as argument and adds it to itself.
 * @author kamar baraka
 * @version 1.0
 * @since 21/05/2023 17:00
 * */

public class Staff {
    private final List<Employee> staff = new ArrayList<>();
    //constructor
    public Staff(){}
    /**
     * @param employee the employee object/s you wish to store.
     * */
    public Staff(Employee... employee){
        for (Employee eachEmployee : employee)
            add(eachEmployee);
    }

    /**@param employee
     * takes an employee object as parameter*/
    public void add(Employee employee){
        staff.add(employee);
    }
    /**@param name supply the name of the employee
     * @return com.kamarbaraka.practice.Employee the employee object*/
    public Employee get(String name){
        Employee employee = null;
        for (Employee each : staff)
            if (each.getName().equalsIgnoreCase(name))
                employee = each;
        return employee;
    }

    /**@return String.
     * not fully developed*/
    public Object[] getStaff(){
        return staff.toArray().clone();
    }
    public static void main(String[] args){
    }
}

