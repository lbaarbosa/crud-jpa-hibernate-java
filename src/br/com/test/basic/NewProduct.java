package br.com.test.basic;

import br.com.infrastructure.DataAccessObject;
import br.com.model.basic.Product;

public class NewProduct {

    public static void main(String[] args) {

        Product product = new Product("STANDARD seat @ Super Bowl 2022 (children)", 69.9);

        DataAccessObject<Product> dataAccessObject = new DataAccessObject<>(Product.class);
        dataAccessObject.atomicInsert(product).close();

    }



}
