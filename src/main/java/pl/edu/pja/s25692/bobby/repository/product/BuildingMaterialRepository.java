package pl.edu.pja.s25692.bobby.repository.product;

import org.springframework.data.repository.CrudRepository;
import pl.edu.pja.s25692.bobby.model.product.BuildingMaterial;

public interface BuildingMaterialRepository extends CrudRepository<BuildingMaterial, Long> {
}
