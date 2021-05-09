package business.entities;

import java.util.ArrayList;
import java.util.List;

public class Basket {


private List<Carport> StandardOrderList = new ArrayList<>();
    private int orderId;

    public Basket() {

    }

    public List<Carport> getStandardOrderList(){
        return StandardOrderList;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void addToCart(Carport carport){
        StandardOrderList.add(carport);
    }

    public double getTotalPrice()
    {
        int sum= 0;
        for(Carport carport:StandardOrderList)
        {
            sum+=carport.getPrice();
        }
        return sum;

    }







}
