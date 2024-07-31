package pl.edu.pja.s25692.bobby.model.misc;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

@Entity
@Value
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Pattern(regexp = "|\\S.*", message = "Street cannot be empty")
    @Size(min = 3, max = 100, message = "Street must be between 3 and 100 characters")
    String street;

    @NotBlank(message = "House number cannot be null or empty")
    @Size(min = 1, max = 10, message = "House number must be between 1 and 10 characters")
    String houseNumber;

    @Size(min = 1, max = 10, message = "Apartment number must be between 1 and 10 characters")
    @Pattern(regexp = "|\\S.*", message = "Apartment number cannot be empty")
    String apartmentNumber;

    @NotBlank(message = "City cannot be null or empty")
    @Size(min = 3, max = 100, message = "City must be between 3 and 100 characters")
    String city;

    @NotBlank(message = "Postal code cannot be null or empty")
    @Pattern(regexp = "\\d{2}-\\d{3}", message = "Postal code must be in the format XX-XXX")
    @Size(min = 6, max = 6, message = "Postal code must be 6 characters long")
    String postalCode;

    @Pattern(regexp = "|\\S.*", message = "Post office cannot be empty")
    @Size(min = 3, max = 100, message = "Post office must be between 3 and 100 characters")
    String postOffice;
}
