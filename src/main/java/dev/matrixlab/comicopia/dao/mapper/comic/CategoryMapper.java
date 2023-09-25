package dev.matrixlab.comicopia.dao.mapper.comic;

import dev.matrixlab.comicopia.entity.comic.CategoryDO;
import dev.matrixlab.comicopia.vo.comic.CategoryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryMapper {

    int insertCategory(CategoryDO categoryDO);

    int countCategoriesByName(@Param("categoryName") String categoryName);

    int deleteCategoryById(@Param("id") Long id);

    int countCategoriesById(@Param("id") Integer id);

    int updateCategoryById(CategoryDO categoryDO);

    List<CategoryVO> selectCategories();

    List<CategoryVO> selectCategoriesByName(@Param("categoryName") String categoryName);
}
