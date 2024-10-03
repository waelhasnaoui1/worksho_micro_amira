package org.wael.microservice_workshp_maven.service.category;

import org.wael.microservice_workshp_maven.dto.CategoryRequest;
import org.wael.microservice_workshp_maven.entities.Category;

import java.util.List;

public interface CategoryService {

    Category createCategory (CategoryRequest categoryDTO);

    List<Category> getAllCategories();
}
