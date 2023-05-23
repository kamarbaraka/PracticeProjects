
import java.text.NumberFormat;
import java.util.*;
import java.time.*;
/**
 * a simple java program to store staff information of a company.
 * the staff object stores the number and information of employees in the company.
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
     * @return Employee the employee object*/
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
        //sample code
        Staff staff = new Staff();
        LocalDate date = LocalDate.now();
        Employee kamar = new Employee("kamar", 10_000.00, date);
        staff.add(kamar);
        var staffs = staff.getStaff();
    }
}

/**
 * a simple class to store employee information.
 * it takes the employee name, initial salary and date of employment and stores it.
 * it has methods {@code  getName()}, {@code  getSalary()}, {@code  getHireDate()} that returns the name,
 * the salary and the date of hire respectively. It also has methods {@code  raiseSalary()} that raises the
 * salary of the particular employee by a percentage,saves it and returns the resultant value. Method {@code  info()}
 * returns an array that contains. the information of the particular employee and {@code toString()} that returns a
 * string representation of the object
 * @author kamar baraka
 * @version 2.0
 * */
class Employee{
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
     * @param name the name of the employee
     * @param  salary the agreed salary
     * @param hireDay the date the employee was hired. It should be a local date object*/
    public Employee(String name, double salary, LocalDate hireDay){
        this.name = Objects.requireNonNull(name, "the name can't be null!");
        this.salary = salary;
        this.hireDay = Objects.requireNonNull(hireDay, "the date can't be null");
    }
    /**
     * @param name the name of the employee
     * @param hireDay {@link  LocalDate} object to represent the date of hire
     * */
    public Employee(String name, LocalDate hireDay){
        this(name, 0, hireDay);
    }
    /**
     * @param name the name of the employee*/
    public Employee(String name){
        this(name, LocalDate.now());
    }

    public Employee(){}
    /**@return int employee id*/
    public int getId(){
        return this.id;
    }
    /**@return the name of the employee*/
    public String getName(){
        return this.name;
    }
    /**@param salary the salary of the employee*/
    public void setSalary(double salary){
        this.salary = salary;
    }
    /**@return the salary of the employee*/
    public double getSalary(){
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return this.salary;
    }
    /**@return the date of hire*/
    public LocalDate getHireDay(){
        return this.hireDay;
    }
/**@param percentage the percentage of the raise*/
    public double raiseSalary(double percentage){
        var raise = this.salary * (percentage/100.0);
        this.salary += raise;
        return this.salary;
    }
    /**@return an array containing employee info*/
    public Object[] info(){
        return new Object[]{id, name, salary, hireDay};
    }
    /**@return String representation of object*/
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
    public static void main(String[] args){
        var date = LocalDate.now();
        Employee employee = new Employee("kamar baraka", 20000, date);
        //System.out.println(Arrays.toString(employee.info()));

        System.out.println(employee.toString());
    }
}
