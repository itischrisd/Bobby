package pl.edu.pja.s25692.bobby.repository.config;

import org.springframework.data.repository.CrudRepository;
import pl.edu.pja.s25692.bobby.model.misc.ConfigParameter;

public interface ConfigParameterRepository extends CrudRepository<ConfigParameter, String>{
}
