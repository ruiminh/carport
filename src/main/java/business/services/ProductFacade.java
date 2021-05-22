package business.services;

import business.entities.Product;
import business.exceptions.UserException;
import business.persistence.ProductMapper;

import java.util.List;

public class ProductFacade {

    ProductMapper productMapper;




    public Product addProduct(String name,double price, int quantity) throws UserException {

        Product product = new Product(name,price,quantity);
        productMapper.addProduct(product);
        return product;


    }



}

