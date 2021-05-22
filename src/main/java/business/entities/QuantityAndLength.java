package business.entities;

public class QuantityAndLength {
    private int quantity;
    private int length;

    public QuantityAndLength(int quantity, int length) {
        this.quantity = quantity;
        this.length = length;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getLength() {
        return length;
    }
}
