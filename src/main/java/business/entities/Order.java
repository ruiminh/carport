package business.entities;

public class Order {

    private int orderId;
    private int customerId;
    private int employeeId;
    private int length;
    private int width;
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

    public Order() {

    }

    public Order(int length, int width, int incline, int shedLenght, int shedHight, int shedWidth, int shedWalltype, int shedFloorType, double price) {
        this.length = length;
        this.width = width;
        this.incline = incline;
        this.shedLenght = shedLenght;
        this.shedHight = shedHight;
        this.shedWidth = shedWidth;
        this.shedWalltype = shedWalltype;
        this.shedFloorType = shedFloorType;
        this.price = price;
    }

    public Order(int customerId, int quantity, double price) {

        this.customerId = customerId;
        this.quantity = quantity;
        this.price = price;

    }
}
