package org.wael.microservice_workshp_maven.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wael.microservice_workshp_maven.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
