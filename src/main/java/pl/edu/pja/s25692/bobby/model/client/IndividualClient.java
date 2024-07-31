package pl.edu.pja.s25692.bobby.model.client;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import pl.edu.pja.s25692.bobby.model.misc.Address;
import pl.edu.pja.s25692.bobby.model.order.Order;
import pl.edu.pja.s25692.bobby.model.service.Reservation;
import pl.edu.pja.s25692.bobby.model.validation.OnlyOneClientType;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "individual_client")
@OnlyOneClientType
public class IndividualClient implements IClient, IGuestClient, IRegisteredClient, IRegularClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name cannot be null or empty")
    @Size(min = 2, max = 100, message = "First name must be between 3 and 100 characters")
    private String firstName;

    @NotBlank(message = "Last name cannot be null or empty")
    @Size(min = 2, max = 100, message = "Last name must be between 3 and 100 characters")
    private String lastName;

    @NotBlank(message = "Email cannot be null or empty")
    @Size(min = 3, max = 100, message = "Email must be between 3 and 100 characters")
    @Email(message = "Email must be valid")
    private String email;

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @NotNull(message = "Address cannot be null")
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "individualClient", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private Set<Order> orders = new HashSet<>();

    @OneToMany(mappedBy = "individualClient", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private Set<Reservation> reservations = new HashSet<>();

    @OneToOne(mappedBy = "individualClient", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private GuestClient guestClient;

    @OneToOne(mappedBy = "individualClient", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private RegisteredClient registeredClient;

    @OneToOne(mappedBy = "individualClient", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private RegularClient regularClient;

    @Override
    public GuestClient asGuestClient() {
        if (guestClient == null) {
            throw new IllegalStateException("Client is not a guest client");
        }
        return guestClient;
    }

    @Override
    public RegisteredClient asRegisteredClient() {
        if (registeredClient == null) {
            throw new IllegalStateException("Client is not a registered client");
        }
        return registeredClient;
    }

    @Override
    public RegularClient asRegularClient() {
        if (regularClient == null) {
            throw new IllegalStateException("Client is not a regular client");
        }
        return regularClient;
    }

    public void toGuestClient(String phoneNumber) {
        if (guestClient != null) {
            throw new IllegalStateException("Client is already a guest client");
        }
        guestClient = GuestClient.builder()
                .phoneNumber(phoneNumber)
                .individualClient(this)
                .build();
        if (registeredClient != null) {
            registeredClient.setIndividualClient(null);
            registeredClient = null;
        }
        if (regularClient != null) {
            regularClient.setIndividualClient(null);
            regularClient = null;
        }
    }

    public void toRegisteredClient(String login, String password) {
        if (registeredClient != null) {
            throw new IllegalStateException("Client is already a registered client");
        }
        registeredClient = RegisteredClient.builder()
                .login(login)
                .password(password)
                .individualClient(this)
                .build();
        if (guestClient != null) {
            guestClient.setIndividualClient(null);
            guestClient = null;
        }
        if (regularClient != null) {
            regularClient.setIndividualClient(null);
            regularClient = null;
        }
    }

    public void toRegularClient(String cardNumber, String cardPin) {
        if (regularClient != null) {
            throw new IllegalStateException("Client is already a regular client");
        }
        regularClient = RegularClient.builder()
                .cardNumber(cardNumber)
                .cardPin(cardPin)
                .individualClient(this)
                .build();
        if (guestClient != null) {
            guestClient.setIndividualClient(null);
            guestClient = null;
        }
        if (registeredClient != null) {
            registeredClient.setIndividualClient(null);
            registeredClient = null;
        }
    }
}
