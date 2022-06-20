package br.com.test.basic;

import br.com.infrastructure.ProductDataAccessObject;
import br.com.model.basic.Product;

import java.util.List;

public class GetProductsList {

    public static void main(String[] args) {

        ProductDataAccessObject productDataAccessObject = new ProductDataAccessObject();
        List<Product> products = productDataAccessObject.getAllEntities();

        for (Product product : products) {
            System.out.println("US$ " + product.getPrice()
                    + ", name: " + product.getName());
        }

        double totalPrice = products
                .stream()
                .map(p -> p.getPrice())
                .reduce(0.0, (t, p) -> t + p);
        System.out.println("The total price is US$ " + totalPrice);

    }
}
