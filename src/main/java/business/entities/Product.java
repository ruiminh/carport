package business.entities;

public class Product {

    private int carportId;
    private String name;
    private double price;
    private int quantity;
    private String pictureUrl;


    public Product(int carportId, String name, double price, int quantity, String pictureUrl) {
        this.carportId = carportId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.pictureUrl = pictureUrl;
    }

    public Product(int carportId, String name, double price) {

        this.carportId = carportId;
        this.name = name;
        this.price = price;

    }

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;

    }

    public Product(int carportId, String name, double price, int quantity) {

        this.carportId=carportId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;




    }

    public int getCarportId() {
        return carportId;
    }

    public void setCarportId(int carportId) {
        this.carportId = carportId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
