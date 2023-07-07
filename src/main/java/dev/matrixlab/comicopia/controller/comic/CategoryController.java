package dev.matrixlab.comicopia.controller.comic;

import dev.matrixlab.comicopia.dto.comic.CategoryDTO;
import dev.matrixlab.comicopia.dto.system.CallbackData;
import dev.matrixlab.comicopia.service.comic.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/createCategory")
    public CallbackData createCategory(@RequestBody CategoryDTO categoryDTO) {
        return CallbackData.build(true, () -> {
            categoryService.createCategory(categoryDTO);
        });
    }

    @DeleteMapping("/deleteCategoryById")
    public CallbackData deleteCategoryById(@RequestParam("categoryId") Long categoryId) {
        return CallbackData.build(true, () -> {
            categoryService.deleteCategoryById(categoryId);
        });
    }

    @PutMapping("/updateCategoryById")
    public CallbackData updateCategoryById(@RequestBody CategoryDTO categoryDTO) {
        return CallbackData.build(true, () -> {
            categoryService.updateCategoryById(categoryDTO);
        });
    }

    @GetMapping("/getCategoryListByName")
    public CallbackData getCategoryListByName(@RequestParam("categoryName") String categoryName) {
        return CallbackData.build(true, categoryService.getCategoryListByName(categoryName));
    }

}
