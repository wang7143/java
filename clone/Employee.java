package clone;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Cloneable{

    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        hireDay = new Date();
    }

    public Object clone() throws CloneNotSupportedException {
        // call Object.clone()
        Employee cloned = (Employee) super.clone();

        //clone mutable fields
        cloned.hireDay = (Date) hireDay.clone();

        return cloned;
    }

    /**
     * Set the hire day a given date.
     * @param year the year of the hire day
     * @param month the month of the hire day
     * @param day the of the hire day
     */

    public void setHireDay(int year, int month, int day) {
        Date newHireDate = new GregorianCalendar(year, month - 1, day).getTime();

        // Example of instance field mutation
        hireDay.setTime(newHireDate.getTime());
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public String toString() {
        return "Employee[name=" + name + ",salary=" + salary + ".hireDay=" + hireDay + "]";
    }
}