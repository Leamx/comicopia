package dev.matrixlab.comicopia.dao.mapper.comic;

import dev.matrixlab.comicopia.dto.comic.CategoryDTO;
import dev.matrixlab.comicopia.entity.comic.CategoryDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryMapper {

    int insertCategory(CategoryDO categoryDO);

    Integer nameDuplicateCheck(@Param("categoryName") String categoryName);

    int deleteCategoryById(Long categoryId);

    int checkCategoryExistById(Integer id);

    int updateCategoryById(CategoryDO categoryDO);

    List<CategoryDTO> listCategories();

    List<CategoryDTO> listCategoriesByName(String categoryName);
}
