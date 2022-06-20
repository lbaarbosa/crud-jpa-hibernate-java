package br.com.test.onetoone.relationship;

import br.com.infrastructure.DataAccessObject;
import br.com.model.onetoone.relationship.Customer;
import br.com.model.onetoone.relationship.Seat;

public class NewCustomerWithSeat {
    public static void main(String[] args) {

        Seat seat = new Seat("2B");
        Customer customer = new Customer("Leonardo", seat);

//        DataAccessObject<Object> dataAccessObject = new DataAccessObject<>();
//        dataAccessObject.beginTransaction()
//                .insert(seat)
//                .insert(client)
//                .commitTransaction()
//                .close();

        DataAccessObject<Customer> dataAccessObject = new DataAccessObject<>(Customer.class);
        dataAccessObject.atomicInsert(customer);
    }
}
