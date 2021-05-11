package business.persistence;

import business.entities.Product;
import business.exceptions.UserException;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductMapper {


    Database database;

    public ProductMapper(Database database){

        this.database = database;

    }



    public List<Product> findAllProduct() throws UserException {

        List<Product> productList = new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM standardcarport";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    int carportId = rs.getInt("carportId");
                    String name = rs.getString("name");
                    double price = rs.getDouble("price");

                    productList.add(new Product(carportId,name,price));

                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
    }


    public void addProduct(Product product) throws UserException {


        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO order (StandardCarportName, price) VALUES (?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setString(1, product.getName());
                ps.setDouble(2, product.getPrice());

                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                product.setCarportId(id);
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException | UserException ex)
        {
            throw new UserException(ex.getMessage());
        }







    }






}
