package generi;

public class order<T> {

    String orderName;
    int orderId;

    T orderT;

    public order(){}

    public order(String orderName, int orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    };
}
