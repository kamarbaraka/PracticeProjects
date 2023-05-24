package com.kamarbaraka.practice;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

/**
 * a simple class to store employee information.
 * it takes the employee name, initial salary and date of employment and stores it.
 * it has methods: {@code getName()}, {@code getSalary()}, {@code getHireDate()} that returns the name,
 * the salary and the date of hire respectively. It also has methods {@code raiseSalary()} that raises the
 * salary of the particular employee by a percentage,saves it and returns the resultant value. Method {@code  info()}
 * returns an array that contains. the information of the particular employee and {@code toString()} that returns a
 * string representation of the object
 * @see Staff
 * @author kamar baraka
 * @version 2.0
 */
public class Employee {
    private static int nextId;
    private static final Random random = new Random();
    private final int id;
    private String name;
    private double salary;
    private LocalDate hireDay;

    //static initialization block
    static {
        nextId = random.nextInt(10_000);
    }

    //object initialization block
    {
        id = nextId;
        nextId++;
        name = "";
        hireDay = LocalDate.now();
    }

    /**
     * @param name    the name of the employee
     * @param salary  the agreed salary
     * @param hireDay the date the employee was hired. It should be a local date object
     */
    public Employee(String name, double salary, LocalDate hireDay) {
        this.name = Objects.requireNonNull(name, "the name can't be null!");
        this.salary = salary;
        this.hireDay = Objects.requireNonNull(hireDay, "the date can't be null");
    }

    /**
     * @param name    the name of the employee
     * @param hireDay {@link  LocalDate} object to represent the date of hire
     */
    public Employee(String name, LocalDate hireDay) {
        this(name, 0, hireDay);
    }

    /**
     * @param name the name of the employee
     */
    public Employee(String name) {
        this(name, LocalDate.now());
    }

    public Employee() {
    }

    /**
     * @return {@code int} employee id
     */
    public int getId() {
        return this.id;
    }

    /**
     * @return {@code String} the name of the employee
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param salary the salary of the employee
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * @return {@code double} the salary of the employee
     */
    public double getSalary() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return this.salary;
    }

    /**
     * @return {@code LocalDate} the date of hire
     */
    public LocalDate getHireDay() {
        return this.hireDay;
    }

    /**
     * @param percentage the percentage of the raise
     * @return <em>double</em> the salary
     */
    public double raiseSalary(double percentage) {
        var raise = this.salary * (percentage / 100.0);
        this.salary += raise;
        return this.salary;
    }

    /**
     * @return an <em>array</em> containing employee info
     */
    public Object[] info() {
        return new Object[]{id, name, salary, hireDay};
    }

    /**
     * @return <em>String</em> representation of object
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", salary=").append(salary);
        sb.append(", hireDay=").append(hireDay);
        sb.append('}');
        return sb.toString();
    }

    //unit test
    public static void main(String[] args) {
    }
}
