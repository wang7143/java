package BaseDao;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public interface CustimerDAO {
    
    void insert(Connection con,Customer cust);

    void deleteById(Connection con,int id);

    void update(Connection con,Customer cust);

    Customer getCustomerBiId(Connection con,int id);

    List<Customer> getAll(Connection con);

    Long getCount(Connection con);

    Date getMaxBirth(Connection con);


}
