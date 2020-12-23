package jdbc;

import java.sql.Date;

public class order {
    
    private int orderID;
    private String orderName;
    private Date date;

    public order() {
    }

    public order(int orderID, String orderName, Date date) {
        this.orderID = orderID;
        this.orderName = orderName;
        this.date = date;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "order [date=" + date + ", orderID=" + orderID + ", orderName=" + orderName + "]";
    }
    
}
