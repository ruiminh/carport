package business.entities;

public class Carport {

    private int piecesId;
    private int orderId;
    private int length;
    private int width;
    private double price;
    private String description;

    public Carport(int piecesId, int orderId, int length, int width, double price, String description) {
        this.piecesId = piecesId;
        this.orderId = orderId;
        this.length = length;
        this.width = width;
        this.price = price;
        this.description = description;
    }

    public int getPiecesId() {
        return piecesId;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
