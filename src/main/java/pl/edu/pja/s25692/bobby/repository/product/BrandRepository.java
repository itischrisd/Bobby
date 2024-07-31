package pl.edu.pja.s25692.bobby.repository.product;

import org.springframework.data.repository.CrudRepository;
import pl.edu.pja.s25692.bobby.model.product.Brand;

public interface BrandRepository extends CrudRepository<Brand, Long> {
}
