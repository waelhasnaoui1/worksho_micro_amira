package org.wael.microservice_workshp_maven.service.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.wael.microservice_workshp_maven.dto.CategoryRequest;
import org.wael.microservice_workshp_maven.entities.Category;
import org.wael.microservice_workshp_maven.repository.CategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category createCategory (CategoryRequest categoryDTO) {
        Category category = new Category();
        category.setName (categoryDTO.name());
        category.setDescription (categoryDTO.description());
// Perform other necessary operations
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

}
