package project02;

/**
  *!@description: 负责菜单和操作
  *@author: dong
  *@date: 2020-09-17 11:09:07
  *@version: V1.0.5
*/

public class CustomerView{
    private CustomerList customerList = new CustomerList(10);
	
	public CustomerView(){
		Customer customer = new Customer("张三", '男', 30, "010-56253825",
		"abc@email.com");
		customerList.addCustomer(customer);
	}
    /**
	 * 显示软件界面
	 */
    public void enterMainMenu() {
		boolean isFlag = true;
		while(isFlag){
			System.out.println("\n--------------客户信息管理软件--------------");
			System.out.println("                 1 添加客户");
			System.out.println("                 2 修改客户");
			System.out.println("                 3 删除客户");
			System.out.println("                 4 客户列表");
			System.out.println("                请选择(1-5)：");

			char menu = CMUtility.readMenuSelection();
			switch (menu) {
				case '1':
					addNewCustomer();
					break;
				case '2':
					modifyCustomer();
					break;
				case '3':
					deleteCustomer();
					break;
				case '4':
					listAllCustimers();
					break;
				case '5':
					System.out.println("确认是否退出(Y/N)");
					char isEXit = CMUtility.readConfirmSelection();
					if (isEXit == 'Y'){
						isFlag = false;
					}
					
			}
		}
		
	}
	
	
	private void listAllCustimers() {
		System.out.println("--------------客户列表--------------");
		int total = customerList.getTotal();
		if(total == 0){
			System.out.println("没有客户记录");
		}
		else{
			System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t邮箱");
			Customer[] custs = customerList.getAllCustomers();
			for(int i = 0; i < custs.length; i++){
				System.out.println(i + 1 + "\t" + custs[i].getName() + "\t" + custs[i].getGender() + "\t" + custs[i].getAge() + "\t" + custs[i].getPhone() + "\t" + custs[i].getEmail());
			}
		}
	}

	private void deleteCustomer() {
		System.out.println("-----------删除客户-----------");
		Customer cust;
		int number;
		while (true) {
			System.out.println("请输入用户编号（-1）退出");
			number = CMUtility.readInt();
			if(number == -1){
				return;
			}
			cust = customerList.getCustomer(number - 1);
			if(cust == null){
				System.out.println("无法找到客户");
			}
			else{
				break;
			}
		}

		System.out.println("是否确认删除(Y/N)");
		char isDel = CMUtility.readConfirmSelection();
		if(isDel == 'Y'){
			customerList.deleteCustomer(number - 1);
		}
	}

	private void modifyCustomer() {
		Customer cust;
		int number;
		System.out.println("----------修改客户----------");
		// cust = circulate(cust, number);
		
		// if (cust == null){
		// 	return;
		// }
		while (true) {
			System.out.println("请输入用户编号（-1）退出");
			number = CMUtility.readInt();
			if(number == -1){
				return;
			}
			cust = customerList.getCustomer(number - 1);

			if(cust == null){
				System.out.println("无法找到客户");
			}
			else{
				break;
			}
		}

		System.out.println("姓名(" + cust.getName() + "):");
		String name = CMUtility.readString(10,cust.getName());
		System.out.println("性别(" + cust.getGender() + "):");
		char gender = CMUtility.readChar(cust.getGender());
		System.out.println("年龄(" + cust.getAge() + "):");
		int age = CMUtility.readInt(cust.getAge());
		System.out.println("电话(" + cust.getPhone() + "):");
		String phone = CMUtility.readString(13,cust.getPhone());
		System.out.println("email(" + cust.getEmail() + "):");
		String email = CMUtility.readString(30,cust.getEmail());

		Customer newcustomer = new Customer(name,gender,age,phone,email);

		boolean isRe = customerList.replaceCustomer(number, newcustomer);
		if(isRe){
			System.out.println("-----------修改完成-----------");
		}
		else{
			System.out.println("-----------修改失败-----------");
		}
	}

	/**
	 * 添加客户
	 */
	private void addNewCustomer() {
		System.out.println("------------添加客户------------");
		System.out.print("姓名：");
		String name = CMUtility.readString(10);
		System.out.print("性别：");
		char gender = CMUtility.readChar();
		System.out.print("年龄：");
		int age = CMUtility.readInt();
		System.out.print("电话：");
		String phone = CMUtility.readString(13);
		System.out.print("邮箱：");
		String email = CMUtility.readString(30);

		Customer customer = new Customer(name,gender,age,phone,email);

		boolean isSu = customerList.addCustomer(customer);
		if (isSu){
			System.out.println("-----------添加成功-----------");
		}
		else{
			System.out.print("-----------添加失败-----------");
			System.out.println("客户已满");
		}
	}
	
	// private Customer circulate(Customer cust, int number) {
	// 	while (true) {
	// 		System.out.println("请输入用户编号（-1）退出");
	// 		number = CMUtility.readInt();
	// 		if(number == -1){
	// 			return null;
	// 		}
	// 		cust = customerList.getCustomer(number - 1);
			
	// 		if(cust == null){
	// 			System.out.println("无法找到客户");
	// 		}
	// 		else{
	// 			return cust;
	// 			// break;
	// 		}

	// 	}
	// }

	public static void main(String[] args) {
		CustomerView view = new CustomerView();
		view.enterMainMenu();
		System.exit(0);
	}
}
