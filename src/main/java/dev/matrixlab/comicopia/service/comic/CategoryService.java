package dev.matrixlab.comicopia.service.comic;

import dev.matrixlab.comicopia.dto.comic.CategoryDTO;
import dev.matrixlab.comicopia.vo.comic.CategoryVO;

import java.util.List;

public interface CategoryService {
    
    String saveCategory(CategoryDTO categoryDTO);

    String removeCategoryById(Long categoryId);

    String updateCategoryById(CategoryDTO categoryDTO);

    List<CategoryVO> listCategoriesByName(String categoryName);

}
