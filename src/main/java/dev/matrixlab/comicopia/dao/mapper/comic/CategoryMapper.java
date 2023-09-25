package dev.matrixlab.comicopia.dao.mapper.comic;

import dev.matrixlab.comicopia.entity.comic.CategoryDO;
import dev.matrixlab.comicopia.vo.comic.CategoryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryMapper {

    int insertCategory(CategoryDO categoryDO);

    Integer nameDuplicateCheck(@Param("categoryName") String categoryName);

    int deleteCategoryById(@Param("id") Long id);

    int checkCategoryExistById(@Param("id") Integer id);

    int updateCategoryById(CategoryDO categoryDO);

    List<CategoryVO> listCategories();

    List<CategoryVO> listCategoriesByName(@Param("categoryName") String categoryName);
}
