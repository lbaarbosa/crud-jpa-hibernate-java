package br.com.test.onetomany.relationship;

import br.com.infrastructure.DataAccessObject;
import br.com.model.onetomany.relationship.Order;
import br.com.model.onetomany.relationship.OrderItem;

public class GetOrder {
    public static void main(String[] args) {

        DataAccessObject<Order> dataAccessObject = new DataAccessObject<>(Order.class);

        Order order = dataAccessObject.getEntityByID(1L);

        for(OrderItem item : order.getItems()) {
            System.out.println(item.getProduct().getName());
            System.out.println(item.getQuantity());
        }

        dataAccessObject.close();
    }
}
