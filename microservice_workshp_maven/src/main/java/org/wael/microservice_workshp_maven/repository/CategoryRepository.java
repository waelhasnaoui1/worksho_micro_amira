package org.wael.microservice_workshp_maven.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.wael.microservice_workshp_maven.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
