package business.entities;

public class UserOrder {

  int id;
  String email;
  int idOrder;
  double price;


    public UserOrder(int id, String email, int idOrder, double price) {
        this.id = id;
        this.email = email;
        this.idOrder = idOrder;
        this.price = price;
    }

    public UserOrder(int id, double price) {

        this.id = id;
        this.price = price;

    }



    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public double getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return "UserOrder{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", idOrder=" + idOrder +
                ", price=" + price +
                '}';
    }
}
