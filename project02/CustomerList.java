package project02;

/**
  *!@description: 为Customer 对象管理模块，并提供增删改查。
  *@author: dong
  *@date: 2020-09-17 11:08:07
  *@version: V1.0.5
*/

public class CustomerList {
    private Customer[] customers;
    private int total = 0;

    /**
     * 用来初始化数组构造器
     * @param totalcustomer，长度
     * 
     */
    public CustomerList(int totalcustomer) {
        customers = new Customer[totalcustomer];
    }

    /**
     * @Description 添加指定客户
     * @param customer 对象
     * @return 真假
     */
    public boolean addCustomer(Customer customer) {
        if (total >= customers.length){
            return false;
        }
        customers[total++] = customer;
        return true;
    }

    /**
     * @Description 搜索客户是否存在
     * @param index
     * @param cust
     * @return 真假
     */
    public boolean replaceCustomer(int index, Customer cust) {
        if (index < 0 || index >= total){
            return false;
        }
        customers[index] = cust;
        return true;
    }

    /**
     * 删除指定客户
     * @param index
     * @return
     */
    public boolean deleteCustomer(int index) {
        if (index < 0 || index >= total){
            return false;
        }

        for (int i = index; i < total-1; i++){
            customers[i] = customers[i+1];
        }

        customers[total--] = null;
        return true;
    }

    /**
     * 获取所有客户信息
     * @return Customer[] 对象
     * 
     */
    public Customer[] getAllCustomers() {
        Customer[] cust = new Customer[total];
        for (int i = 0; i < total; i++){
            cust[i] = customers[i];
        }
        return cust;
    }

    /**
     * 获取指定位置客户
     * @param index
     * @return 
     */
    public Customer getCustomer(int index){
        if (index < 0 || index >= total){
            return null;
        }
        return customers[index];
    }

    /**
     * 
     * @return 客户数量
     */
    public int getTotal() {
        return total;
    }

}
