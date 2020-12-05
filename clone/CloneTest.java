package clone;



/**
 * This program demonstrates cloning
 * @version 2020年9月2日
 * @author Cay Horstmann
 */
public class CloneTest {
    public static void main(String[] args) {
        try{
            Employee original = new Employee("John Q. Public", 50000);
            original.setHireDay(200, 1, 1);
            Employee copy = (Employee) original.clone();
            copy.raiseSalary(10);
            copy.setHireDay(2002, 12, 31);
            System.out.println("original=" + original);
            System.out.println("copy=" + copy);
        }
        catch(CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
    }
}