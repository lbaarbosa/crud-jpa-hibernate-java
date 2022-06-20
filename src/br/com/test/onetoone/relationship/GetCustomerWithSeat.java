package br.com.test.onetoone.relationship;

import br.com.infrastructure.DataAccessObject;
import br.com.model.onetoone.relationship.Customer;
import br.com.model.onetoone.relationship.Seat;

public class GetCustomerWithSeat {
    public static void main(String[] args) {

        DataAccessObject<Customer> clientDataAccessObject = new DataAccessObject<>(Customer.class);

        Customer customer = clientDataAccessObject.getEntityByID(1L);
        System.out.println(customer
                .getSeat()
                .getName());

        clientDataAccessObject.close();

        DataAccessObject<Seat> seatDataAccessObject = new DataAccessObject<>(Seat.class);
        Seat seat = seatDataAccessObject.getEntityByID(1L);
        System.out.println(seat
                .getClient()
                .getName());

        seatDataAccessObject.close();
    }
}
