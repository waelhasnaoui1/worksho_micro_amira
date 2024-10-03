package org.wael.microservice_workshp_maven.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wael.microservice_workshp_maven.dto.ProductRequest;
import org.wael.microservice_workshp_maven.dto.ProductResponse;
import org.wael.microservice_workshp_maven.entities.Product;
import org.wael.microservice_workshp_maven.service.product.ProductService;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest productRequest)
            throws IOException, IOException {
        ProductResponse productResponse = productService.addProduct(productRequest);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<Product> products = productService.getAllProduct();
        List<ProductResponse> productResponses = new ArrayList<>();
        products.forEach(product -> {
            productResponses.add(
                    new ProductResponse(product.getId(),
                            product.getName(),
                            product.getDescription(),
                            product.getPrice(),
                            product.getCategory().getId(),
                            product.getQuantity()
                    ));
        });
        return ResponseEntity.ok(productResponses);
    }
}
