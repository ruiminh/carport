package business.entities;

import java.util.ArrayList;
import java.util.List;

public class Basket {


private static final List<Product> productList = new ArrayList<>();
    private int orderId;

    public Basket() {

    }

    public List<Product> getProductList(){
        return productList;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void addToCart(Product product){ productList.add(product); }

    public double getTotalPrice()
    {
        double sum= 0;
        for(Product product:productList)
        {
            sum+=product.getPrice();
        }
        return sum;

    }


}
