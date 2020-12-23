package BaseDao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;


public class Custimpl extends Dao<Customer> implements CustimerDAO {

    
    @Override
    public void insert(Connection con, Customer cust) {
        String sql = "insert into customers(name,email,birth)values(?,?,?)";
        update(con, sql, cust.getName(),cust.getEmail(),cust.getBirth());
    }

    @Override
    public void deleteById(Connection con, int id) {
        String sql = "delete from customers where id = ?";
        update(con, sql, id);
    }

    @Override
    public void update(Connection con, Customer cust) {
        String sql = "update customers set name = ?,email = ?,birth = ? where id = ?";
        update(con, sql, cust.getName(),cust.getEmail(),cust.getBirth(),cust.getId());
    }

    @Override
    public Customer getCustomerBiId(Connection con, int id) {
        String sql = "select id,name,email,birth from customers where id = ?";
        Customer customer = get(con, sql, id);
        return customer;
    }

    @Override
    public List<Customer> getAll(Connection con) {
        String sql = "select id,name email,birth from customers";
        List<Customer> getmut = getmut(con, sql);
        return getmut;
    }

    @Override
    public Long getCount(Connection con) {
        String sql = "select count(*) from customers";
        return getValue(con, sql);
    }

    @Override
    public Date getMaxBirth(Connection con) {
        String sql = "select max(birth) from customers";
        return getValue(con, sql);
    }

    
}
