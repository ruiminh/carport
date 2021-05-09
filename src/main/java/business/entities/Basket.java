package business.entities;

import java.util.ArrayList;
import java.util.List;

public class Basket {


private List<Order> StandardOrderList = new ArrayList<Order>();
    private int orderId;

    public Basket() {

    }

    public List<Order> getStandardOrderList(){
        return StandardOrderList;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void addToCart(Order order){
        StandardOrderList.add(order);
    }

    public double getTotalPrice()
    {
        double sum= 0;
        for(Order carport:StandardOrderList)
        {
            sum+=carport.getPrice();
        }
        return sum;

    }







}
