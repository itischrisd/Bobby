package pl.edu.pja.s25692.bobby.repository.product;

import org.springframework.data.repository.CrudRepository;
import pl.edu.pja.s25692.bobby.model.product.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
