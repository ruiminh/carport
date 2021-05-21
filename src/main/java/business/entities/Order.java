package business.entities;

public class Order {

    private int orderId;
    private int customerId;
    private int employeeId;
    private int carportlength;
    private int carportwidth;
    private int incline;
    private int rooftileType;
    private int withShed;
    private int shedLenght;
    private int shedHight;
    private int shedWidth;
    private int shedWalltype;
    private int shedFloorType;
    private int quantity;
    private double price;
    private String comments;
    private boolean isAccepted;
    private boolean isDelivered;

    public Order(int carportlength, int carportwidth, int rooftileType, int shedLenght, int shedWidth) {
        this.carportlength = carportlength;
        this.carportwidth = carportwidth;
        this.rooftileType = rooftileType;
        this.shedLenght = shedLenght;
        this.shedWidth = shedWidth;
    }

    public Order(int orderId, int customerId, int employeeId, int carportlength, int carportwidth, int withShed, int shedlenght, int shedHight, double price, boolean isAccepted) {

        this.orderId = orderId;
        this.customerId = customerId;
        this.employeeId= employeeId;
        this.carportlength= carportlength;
        this.carportwidth = carportwidth;
        this.withShed = withShed;
        this.shedLenght = shedlenght;
        this.shedHight = shedHight;
        this.price= price;
        this.isAccepted= isAccepted;



    }

    public int getOrderId() {
        return orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getCarportlength() {
        return carportlength;
    }

    public int getCarportwidth() {
        return carportwidth;
    }

    public int getIncline() {
        return incline;
    }

    public int getRooftileType() {
        return rooftileType;
    }

    public int getWithShed() {
        return withShed;
    }

    public int getShedLenght() {
        return shedLenght;
    }

    public int getShedHight() {
        return shedHight;
    }

    public int getShedWidth() {
        return shedWidth;
    }

    public int getShedWalltype() {
        return shedWalltype;
    }

    public int getShedFloorType() {
        return shedFloorType;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getComments() {
        return comments;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public boolean isDelivered() {
        return isDelivered;
    }
}