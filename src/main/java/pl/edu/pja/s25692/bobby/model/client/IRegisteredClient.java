package pl.edu.pja.s25692.bobby.model.client;

public interface IRegisteredClient {

    RegisteredClient asRegisteredClient();

    default String getLogin() {
        return asRegisteredClient().getLogin();
    }

    default void setLogin(String login) {
        asRegisteredClient().setLogin(login);
    }

    default String getPassword() {
        return asRegisteredClient().getPassword();
    }

    default void setPassword(String password) {
        asRegisteredClient().setPassword(password);
    }
}
