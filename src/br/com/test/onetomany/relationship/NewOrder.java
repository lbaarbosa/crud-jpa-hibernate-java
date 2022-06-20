package br.com.test.onetomany.relationship;

import br.com.infrastructure.DataAccessObject;
import br.com.model.onetomany.relationship.Order;
import br.com.model.basic.Product;
import br.com.model.onetomany.relationship.OrderItem;

public class NewOrder {
    public static void main(String[] args) {

        DataAccessObject<Object> dataAccessObject = new DataAccessObject<>();

        Order order = new Order();
        Product product = new Product("PREMIUM seat @ Super Bowl 2022 (children)", 99.9);
        OrderItem orderItem = new OrderItem(order, product, 1);

        dataAccessObject.beginTransaction()
                .insert(product)
                .insert(order)
                .insert(orderItem)
                .commitTransaction()
                .close();
    }
}