package pl.edu.pja.s25692.bobby.model.client;

import pl.edu.pja.s25692.bobby.model.misc.Address;
import pl.edu.pja.s25692.bobby.model.order.Order;
import pl.edu.pja.s25692.bobby.model.service.Reservation;

import java.util.Set;

public interface IClient {

    Address getAddress();

    void setAddress(Address address);

    String getEmail();

    void setEmail(String email);

    Set<Reservation> getReservations();

    Set<Order> getOrders();
}
