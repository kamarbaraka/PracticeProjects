import java.util.*;
import java.time.*;
/**
 * a simple java program to store staff information of a company.
 * the staff object stores the number and information of employees in the company.
 * the staff object has methods {@methods add} and {@methods getStaff}.
 * the add method takes an employee object as argument and adds it to itself.
 * @author kamar baraka
 * @version 1.0
 * @since 21/05/2023 17:00
 * */

public class Staff {
    private static final List<Employee> staff = new ArrayList<>();
    public static void main(String[] args){
        //sample code
        LocalDate date = LocalDate.now();
        Employee kamar = new Employee("kamar", 10_000.00, date);
        Staff.add(kamar);
    }
    /**@param employee
     * takes an employee object as parameter*/
    public static void add(Employee employee){
        staff.add(employee);
    }
    /**@return String.
     * not fully developed*/
    public Object[] getStaff(){
        return staff.toArray().clone();
    }
}

/**
 * a simple class to store employee information.
 * it takes the employee name, initial salary and date of employment and stores it.
 * it has methods {@methods getName}, {@methods getSalary}, {@methods getHireDate} that returns the name,
 * the salary and the date of hire respectively. It also has methods {@methods raiseSalary} that raises the
 * salary of the particular employee by a percentage,saves it and returns the resultant value. Method {@methods info} returns an array that contains
 * the information of the particular employee.
 * */
class Employee{
    private final String name;
    private double salary;
    private final LocalDate hireDay;

    /**
     * @param name the name of the employee
     * @param  salary the agreed salary
     * @param hireDay the date the employee was hired. It should be a local date object*/
    public Employee(String name, double salary, LocalDate hireDay){
        this.name = Objects.requireNonNull(name, "the name can't be null!");
        this.salary = salary;
        this.hireDay = Objects.requireNonNull(hireDay, "the date can't be null");
    }

    public String getName(){
        return this.name;
    }

    public double getSalary(){
        return this.salary;
    }

    public LocalDate getHireDay(){
        return this.hireDay;
    }
/**@param percentage the percentage of the raise*/
    public double raiseSalary(double percentage){
        var raise = this.salary * (percentage/100.0);
        this.salary += raise;
        return this.salary;
    }

    public String[] info(){
        Double castedSalary = (Double) this.salary;
        return new String[]{name, castedSalary.toString(), hireDay.toString()};
    }
}
