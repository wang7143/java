package test.project3;

import org.junit.Test;

public class NameListServiceTest {
    
    @Test
    public void testGetALLEmployees(){
        NameListService service = new NameListService();
        Employee[] employees = service.getAllEmployees();
        for(int i = 0;i < employees.length;i++){
            System.out.println(employees[i]);
        }
    }

    @Test
    public void testGetEmployee(){
        NameListService service = new NameListService();
        try {
            Employee employee = service.getEmployee(101);
            System.out.println(employee);
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
}
