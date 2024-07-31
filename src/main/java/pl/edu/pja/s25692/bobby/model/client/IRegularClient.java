package pl.edu.pja.s25692.bobby.model.client;

public interface IRegularClient {

    RegularClient asRegularClient();

    default String getCardNumber() {
        return asRegularClient().getCardNumber();
    }

    default void setCardNumber(String cardNumber) {
        asRegularClient().setCardNumber(cardNumber);
    }

    default String getCardPin() {
        return asRegularClient().getCardPin();
    }

    default void setCardPin(String cardPin) {
        asRegularClient().setCardPin(cardPin);
    }

    default double getDiscount() {
        return asRegularClient().getDiscount();
    }

    default void setDiscount(double discount) {
        asRegularClient().setDiscount(discount);
    }
}
