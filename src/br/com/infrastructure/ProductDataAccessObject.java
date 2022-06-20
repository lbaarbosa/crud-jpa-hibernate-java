package br.com.infrastructure;

import br.com.model.basic.Product;

public class ProductDataAccessObject extends DataAccessObject<Product> {

    public ProductDataAccessObject() {
        super(Product.class);
    }

}
