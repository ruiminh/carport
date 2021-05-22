package business.entities;

import java.util.ArrayList;
import java.util.List;

public class Basket {


private static final List<Product> cartList = new ArrayList<>();

    private int orderId;

    public Basket() {

    }

    public List<Product> getCartList(){
        return cartList;
    }



    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void addToCart(Product product){ cartList.add(product); }



    public double getTotalPrice()
    {
        double sum= 0;
        for(Product product:cartList)
        {
            sum+=product.getPrice();
        }
        return sum;

    }

    @Override
    public String toString() {
        return "Basket{" +
                "orderId=" + orderId +
                '}';
    }
}
