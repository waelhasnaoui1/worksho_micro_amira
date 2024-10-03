package org.wael.microservice_workshp_maven.service.product;

import org.wael.microservice_workshp_maven.dto.ProductRequest;
import org.wael.microservice_workshp_maven.dto.ProductResponse;
import org.wael.microservice_workshp_maven.entities.Product;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    public ProductResponse addProduct (ProductRequest productRequest) throws IOException;

    public List<Product> getAllProduct () ;
}
