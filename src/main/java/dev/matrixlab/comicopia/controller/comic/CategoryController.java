package dev.matrixlab.comicopia.controller.comic;

import dev.matrixlab.comicopia.dto.comic.CategoryDTO;
import dev.matrixlab.comicopia.entity.system.CallbackData;
import dev.matrixlab.comicopia.service.comic.CategoryService;
import dev.matrixlab.comicopia.utils.CallbackUtils;
import dev.matrixlab.comicopia.vo.comic.CategoryVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(final CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/addCategory")
    public CallbackData<String> addCategory(@RequestBody CategoryDTO categoryDTO) {
        return CallbackUtils.success(categoryService.saveCategory(categoryDTO));
    }

    @DeleteMapping("/deleteCategoryById")
    public CallbackData<String> deleteCategoryById(@RequestParam("categoryId") long categoryId) {
        return CallbackUtils.success(categoryService.removeCategoryById(categoryId));
    }

    @PutMapping("/modifyCategoryById")
    public CallbackData<String> modifyCategoryById(@RequestBody CategoryDTO categoryDTO) {
        return CallbackUtils.success(categoryService.updateCategoryById(categoryDTO));
    }

    @GetMapping("/queryCategoriesByName")
    public CallbackData<List<CategoryVO>> queryCategoriesByName(@RequestParam("categoryName") String categoryName) {
        return CallbackUtils.success(categoryService.listCategoriesByName(categoryName));
    }

}
