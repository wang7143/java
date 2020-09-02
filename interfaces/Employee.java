package interfaces;

public class Employee implements Comparable<Employee>{

    private String name;
    private double salary;

    public Employee(String name, double salary)
    {
        this.name = name;
        this.salary = salary;
    }

    public String getName()
    {
        return name;
    }

    public double getSalary()
    {
        return salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    /**
     * 🏳‍🌈Compares(比较) employees by salary
     * !对比薪水
     * @param other another Employee object
     * @return 🏳‍🌈a negative value(负值) if this employee has a lower salary than other object, 0 if the salaries are the same, a positive value otherwise
     */
    public int compareTo(Employee other) {
        return Double.compare(salary, other.salary); //比较
    }
    
}