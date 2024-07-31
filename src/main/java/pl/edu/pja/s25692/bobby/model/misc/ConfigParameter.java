package pl.edu.pja.s25692.bobby.model.misc;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
public class ConfigParameter {

    @Id
    @NotNull(message = "Key cannot be null")
    private String parameterKey;

    @NotNull(message = "Value cannot be null")
    private String parameterValue;
}
