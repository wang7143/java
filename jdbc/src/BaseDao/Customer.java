package BaseDao;

import java.sql.Date;

public class Customer {
    private int id;
    private String name;
    private String email;
    private java.util.Date birth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public java.util.Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Customer_date [birth=" + birth + ", email=" + email + ", id=" + id + ", name=" + name + "]";
    }

    public Customer() {
    }

    public Customer(int id, String name, String email, java.util.Date birth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birth = birth;
    }
    
    
    
}
