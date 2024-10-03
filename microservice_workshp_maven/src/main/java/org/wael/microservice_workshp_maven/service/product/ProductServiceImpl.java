package org.wael.microservice_workshp_maven.service.product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.wael.microservice_workshp_maven.dto.ProductRequest;
import org.wael.microservice_workshp_maven.dto.ProductResponse;
import org.wael.microservice_workshp_maven.entities.Category;
import org.wael.microservice_workshp_maven.entities.Product;
import org.wael.microservice_workshp_maven.repository.CategoryRepository;
import org.wael.microservice_workshp_maven.repository.ProductRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public ProductResponse addProduct (ProductRequest productRequest) throws IOException {
        Optional<Category> category0pt = categoryRepository.findById(productRequest.categoryId());
        if (category0pt.isEmpty()) {
            throw new IOException("Category with ID " + productRequest.categoryId() + "not found");
        }
        Category category = category0pt.get();
// Build the product entity
        Product product = Product.builder()
                .name (productRequest.name())
                .description(productRequest.description())
                .price (productRequest.price())
                .category (category) // Set the category entity
                .quantity(productRequest.quantity())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved", product.getId());

        return new ProductResponse (
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                category.getId(), // Return the category ID
                product.getQuantity()
        );
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

}

