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
    private static List<Employee> staff = new ArrayList<>();
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
    public String getStaff(){
        return "not yet";
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
     * @param parsedName the name of the employee
     * @param  initialSalary the agreed salary
     * @param parsedHireDay the date the employee was hired. It should be a local date object*/
    public Employee(String parsedName, double initialSalary, LocalDate parsedHireDay){
        name = Objects.requireNonNull(parsedName, "the name can't be null!");
        salary = initialSalary;
        hireDay = Objects.requireNonNull(parsedHireDay, "the date can't be null");
    }

    public String getName(){
        return name;
    }

    public double getSalary(){
        return salary;
    }

    public LocalDate getHireDay(){
        return hireDay;
    }
/**@param percentage the percentage of the raise*/
    public double raiseSalary(double percentage){
        var raise = salary * (percentage/100.0);
        salary += raise;
        return salary;
    }

    public String[] info(){
        Double castedSalary = (Double) salary;
        return new String[]{name, castedSalary.toString(), hireDay.toString()};
    }
}
