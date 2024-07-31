package pl.edu.pja.s25692.bobby.model.client;

public interface IGuestClient {

    GuestClient asGuestClient();

    default String getPhoneNumber() {
        return asGuestClient().getPhoneNumber();
    }

    default void setPhoneNumber(String phoneNumber) {
        asGuestClient().setPhoneNumber(phoneNumber);
    }
}
