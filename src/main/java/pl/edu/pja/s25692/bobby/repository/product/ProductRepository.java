package pl.edu.pja.s25692.bobby.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pja.s25692.bobby.model.product.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
