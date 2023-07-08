package dev.matrixlab.comicopia.service.comic;

import dev.matrixlab.comicopia.dto.comic.CategoryDTO;

import java.util.List;

public interface CategoryService {
    
    void createCategory(CategoryDTO categoryDTO);

    void deleteCategoryById(Long categoryId);

    void updateCategoryById(CategoryDTO categoryDTO);

    List<CategoryDTO> listCategoriesByName(String categoryName);

}
