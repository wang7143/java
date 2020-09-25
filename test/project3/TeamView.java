package test.project3;

public class TeamView {
    private NameListService listSvc = new NameListService();
    private TeamService teamSve = new TeamService();

    public void enterMainMenu() {
        boolean condition = true;
        char menu = '0';
        while (condition) {
            if(menu != '1'){
                listAllEmployees();
            }
            System.out.println("1-团队列表 2-添加团队成员 3-删除团队从成员 4-退出 请选择（1-4）：");
            menu = TSUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.println("是否退出Y/N");
                    char isExit = TSUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        condition = false;
                    }
                    break;
            }
        }
    }

    public void listAllEmployees() {
        System.out.println("---------------开发团队调度成员表---------------");
        Employee[] employees = listSvc.getAllEmployees();
        if (employees == null || employees.length == 0) {
            System.out.println("公司中没有任何员工信息");
        } else {
            System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t设备领用");

            for (int i = 0; i < employees.length; i++) {
                System.out.println(employees[i]);
            }
        }

    }

    public void getTeam() {
        System.out.println("---------------团队成员表---------------");
        Programmer[] team = teamSve.getTeam();
        if (team == null || team.length == 0) {
            System.out.println("开发团队目前没有成员");
        } else {
            System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票\n");
            for (int i = 0; i < team.length; i++) {
                System.out.println(team[i].getDetails());
            }
        }
        System.out.println("-----------------------------------------");
    }

    private void addMember() {
        System.out.println("------------------添加成员------------------");
        System.out.print("请输入员工ID：");
        int id = TSUtility.readInt();

        try {
            Employee EMP = listSvc.getEmployee(id);
            teamSve.addMember(EMP);
            System.out.println("添加成功");
            TSUtility.readReturn();
        } catch (TeamException e) {
            // TODO Auto-generated catch block
            System.out.println("添加失败 " + e.getMessage());
        }

    }

    private void deleteMember() {
        System.out.println("----------------------删除团队成员----------------------");
        System.out.println("请输入要删除的员工ID");
        int id = TSUtility.readInt();
        System.out.println("确认删除Y/N");
        char isDelete = TSUtility.readConfirmSelection();
        if (isDelete == 'N') {
            return;
        }
        try {
            teamSve.removeMember(id);
            System.out.println("删除成功");
        } catch (TeamException e) {
            // TODO Auto-generated catch block
            System.out.println("失败原因" + e.getMessage());
        }
        TSUtility.readReturn();
    }


    public static void main(String[] args) {
        TeamView view = new TeamView();
        view.enterMainMenu();
    }
}
