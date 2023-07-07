package dev.matrixlab.comicopia.service.comic.impl;

import dev.matrixlab.comicopia.dao.mapper.comic.CategoryMapper;
import dev.matrixlab.comicopia.dto.comic.CategoryDTO;
import dev.matrixlab.comicopia.dto.mapper.BeanMapperStruct;
import dev.matrixlab.comicopia.dto.system.CallbackData;
import dev.matrixlab.comicopia.entity.comic.CategoryDO;
import dev.matrixlab.comicopia.service.comic.CategoryService;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;

    @Override
    public void createCategory(CategoryDTO categoryDTO) {
        if (categoryMapper.nameDuplicateCheck(categoryDTO.getName()) > 0) {
            throw new InternalException("The category name is duplicated, creating a category failed.");
        }
        CategoryDO categoryDO = BeanMapperStruct.BEAN_MAPPER_STRUCT.categoryDTO2CategoryDO(categoryDTO);
        Long now = System.currentTimeMillis();
        categoryDO.setGmtCreate(now);
        categoryDO.setGmtModified(now);
        if (categoryMapper.insertCategory(categoryDO) == 0) {
            throw new InternalException("Save failed.");
        }
        CallbackData.setResource("Added successfully.");
    }

    @Override
    public void deleteCategoryById(Long categoryId) {
        if (categoryMapper.deleteCategoryById(categoryId) == 0) {
            throw new InternalException("Delete failed.");
        }
        CallbackData.setResource("Deleted successfully.");
    }

    @Override
    public void updateCategoryById(CategoryDTO categoryDTO) {
        if (categoryMapper.checkCategoryExistById(categoryDTO.getId()) == 0) {
            throw new InternalException("Category does not exist.");
        }
        CategoryDO categoryDO = BeanMapperStruct.BEAN_MAPPER_STRUCT.categoryDTO2CategoryDO(categoryDTO);
        Long now = System.currentTimeMillis();
        categoryDO.setGmtModified(now);
        if (categoryMapper.updateCategoryById(categoryDO) == 0) {
            throw new InternalException("Update failed.");
        }
        CallbackData.setResource("Updated successfully.");

    }

    @Override
    public List<CategoryDTO> getCategoryListByName(String categoryName) {
        if ("".equals(categoryName)) {
            return categoryMapper.getCategoryList();
        } else {
            return categoryMapper.getCategoryListByName(categoryName);
        }

    }
}
