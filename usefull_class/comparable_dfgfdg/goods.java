package usefull_class.comparable_dfgfdg;

public class goods implements Comparable{
    private double price;
    private String name;


    
    public goods(double price, String name) {
        this.price = price;
        this.name = name;
    }
    

    @Override
    public String toString() {
        return "Goods{" + "name='" + name + '\'' + ",price=" + price + '}';
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public goods() {
    }

    public void compareTo() {
        
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof goods){
            goods goods = (goods)o;
            if(this.price > goods.price){
                return 1;
            }else if(this.price < goods.price){
                return -1;
            }else{ 
                return this.name.compareTo(goods.name);
            }

            // return Double.compare(this.price, goods.price);
        }
        throw new RuntimeException("传入数据类型不一致");
    }
    
    
    
}
