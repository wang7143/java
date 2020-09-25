package test.project3;

/**
 * 
 * @Description 负责封装Date数据
 */
public class NameListService {

    private Employee[] employees;

    public NameListService(){
        employees = new Employee[Data.EMPLOYEES.length];

        for(int i = 0;i < employees.length; i++){
            int type = Integer.parseInt(Data.EMPLOYEES[i][0]);
            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name = Data.EMPLOYEES[i][2];
            int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);
            Equipment equipment;
            double bonus;
            int stock;
            switch (type) {
                case Data.EMPLOYEE:
                    employees[i] = new Employee(id,name,age,salary);
                    break;
                case Data.PROGRAMMER:
                    equipment = createEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, equipment);
                    break;
                case Data.DESIGNER:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    employees[i] = new Designer(id, name, age, salary, equipment, bonus);
                    break;
                case Data.ARCHITECT:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
                    break;
            }
        } 
    }

    /**
     * 获取对应的设别
     * 
     * @return
     */
    private Equipment createEquipment(int index) {
        int type = Integer.parseInt(Data.EQIPMENTS[index][0]);
        String model = Data.EQIPMENTS[index][1];
        switch (type) {
            case Data.PC:
                return new PC(model, Data.EQIPMENTS[index][2]);
            case Data.NOTEBOOK:
                double price = Double.parseDouble(Data.EQIPMENTS[index][2]);
                return new NoteBook(model, price);
            case Data.PRINTER:
                return new Printer(model, Data.EQIPMENTS[index][2]);
        }
        return null;

    }

    public Employee[] getAllEmployees() {
        return employees;
    }

    /**
     * 
     * @return
     * @throws TeamException
     */
    public Employee getEmployee(int id) throws TeamException {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                return employees[i];
            }
        }
        throw new TeamException("找不到指定员工");
    }
}
