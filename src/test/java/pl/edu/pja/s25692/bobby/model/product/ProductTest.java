package pl.edu.pja.s25692.bobby.model.product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pl.edu.pja.s25692.bobby.repository.product.AvailableProductMaterialRepository;
import pl.edu.pja.s25692.bobby.repository.product.CategoryRepository;
import pl.edu.pja.s25692.bobby.repository.product.ProductRepository;
import pl.edu.pja.s25692.bobby.repository.product.ToolRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
class ProductTest {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private AvailableProductMaterialRepository availableProductMaterialRepository;
    @PersistenceContext
    private EntityManager entityManager;

    private Product product;
    @Autowired
    private ToolRepository toolRepository;

    @BeforeEach
    void setUp() {
        Category category = Category.builder()
                .name("Category")
                .description("Description")
                .build();
        categoryRepository.save(category);

        AvailableProductMaterial availableProductMaterial = AvailableProductMaterial.builder()
                .name("Material")
                .build();
        availableProductMaterialRepository.save(availableProductMaterial);

        product = Product.builder()
                .name("Product")
                .description("Description")
                .netPrice(BigDecimal.valueOf(100.0))
                .color("Color")
                .category(category)
                .usedMaterials(Set.of(availableProductMaterial))
                .build();
    }

    @Test
    void cannotSaveProductWithoutSubproductPart() {
        assertThrows(Exception.class, () -> productRepository.save(product));
    }

    @Test
    void canSaveProductWithToolPart() {
        Tool tool = Tool.builder()
                .product(product)
                .build();

        product.setTool(tool);
        Product savedProduct = productRepository.save(product);
        assertNotNull(savedProduct.getId());
    }


    @Test
    void canGetProductFromRepository() {
        Tool tool = Tool.builder()
                .product(product)
                .build();
        product.setTool(tool);
        productRepository.save(product);
        toolRepository.save(tool);
        entityManager.flush();
        List<Product> products = productRepository.findAll();
        products.forEach(System.out::println);
        assertNotNull(products);
    }
}