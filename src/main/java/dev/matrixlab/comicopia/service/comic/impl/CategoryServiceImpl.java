package dev.matrixlab.comicopia.service.comic.impl;

import dev.matrixlab.comicopia.dao.mapper.comic.CategoryMapper;
import dev.matrixlab.comicopia.dto.comic.CategoryDTO;
import dev.matrixlab.comicopia.dto.mapper.BeanMapperStruct;
import dev.matrixlab.comicopia.entity.comic.CategoryDO;
import dev.matrixlab.comicopia.service.comic.CategoryService;
import dev.matrixlab.comicopia.vo.comic.CategoryVO;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;

    private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    public CategoryServiceImpl(final CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public String saveCategory(CategoryDTO categoryDTO) {
        if (categoryMapper.countCategoriesByName(categoryDTO.getName()) > 0) {
            throw new InternalException("The category name is duplicated, creating a category failed.");
        }
        CategoryDO categoryDO = BeanMapperStruct.BEAN_MAPPER_STRUCT.categoryDTO2CategoryDO(categoryDTO);
        Long now = System.currentTimeMillis();
        categoryDO.setGmtCreate(now);
        categoryDO.setGmtModified(now);
        if (categoryMapper.insertCategory(categoryDO) == 0) {
            throw new InternalException("Save failed.");
        }
        return "Added category successfully.";
    }

    @Override
    public String removeCategoryById(Long categoryId) {
        if (categoryMapper.deleteCategoryById(categoryId) == 0) {
            throw new InternalException("Delete failed.");
        }
        return "Deleted category successfully.";
    }

    @Override
    public String updateCategoryById(CategoryDTO categoryDTO) {
        if (categoryMapper.countCategoriesById(categoryDTO.getId()) == 0) {
            throw new InternalException("Category does not exist.");
        }
        CategoryDO categoryDO = BeanMapperStruct.BEAN_MAPPER_STRUCT.categoryDTO2CategoryDO(categoryDTO);
        Long now = System.currentTimeMillis();
        categoryDO.setGmtModified(now);
        if (categoryMapper.updateCategoryById(categoryDO) == 0) {
            throw new InternalException("Update failed.");
        }
        return "Updated category successfully.";
    }

    @Override
    public List<CategoryVO> listCategoriesByName(String categoryName) {
        if ("".equals(categoryName)) {
            return categoryMapper.selectCategories();
        } else {
            return categoryMapper.selectCategoriesByName(categoryName);
        }

    }
}
