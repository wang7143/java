package interfaces;

import java.util.*;



/**
 * This program demonstrates the use of the Comparable interface
 * !程序演示用来比较的接口
 * @version 2020年9月1日
 * @author Cay Horstmann
 */

 /**
  * EmployeeSortTest
  */
 public class EmployeeSortTest {
     public static void main(String[] args) {
         Employee[] staff = new Employee[3];
         
         staff[0] = new Employee("Harry Hacker", 35000);
         staff[1] = new Employee("Carl Cracker", 75000);
         staff[2] = new Employee("Tony Tester", 38000);

         Arrays.sort(staff); 
         //todo排序staff数组，要求数组中的元素必须属于实现了Comparable接口的类
         //print out information about all Employee objects
         for (Employee e : staff)
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
     }
 }