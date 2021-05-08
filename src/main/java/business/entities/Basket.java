package business.entities;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<Order> orderList = new ArrayList<>();
    private int orderId;

    public Basket() {

    }

    public List<Order> getOrderList(){
        return orderList;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }
    public void addToCart(Order order){
        orderList.add(order);
    }

    public int totalPrice()
    {
        int sum= 0;
        for(Order order:orderList)
        {
            sum+=Order.getPrice();
        }
        return sum;

    }







}
