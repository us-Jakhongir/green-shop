package uz.webbrain.appgreenshop.controller;

/*
 * project:  app-green-shop
 * author:   Jumanazar Said
 * created:  17/02/2022 1:15 PM
 */

import org.springframework.web.bind.annotation.*;
import uz.webbrain.appgreenshop.dto.request.CategoryDTO;
import uz.webbrain.appgreenshop.entity.Category;
import uz.webbrain.appgreenshop.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    /**
     * CRUD - get categories
     * @return
     */
    @GetMapping("/")
    public List<Category> getCategories(){
        return categoryService.findAll();
    }

    @PostMapping("/add")
    public Category addCategory(@RequestBody CategoryDTO categoryDTO){
        return categoryService.addCategory(categoryDTO);
    }

    @PutMapping("/{category_id}")
    public Category editCategory(@PathVariable Long category_id, @RequestBody CategoryDTO categoryDTO){
        return categoryService.editCategory(category_id, categoryDTO);
    }

    @DeleteMapping("/{category_id}")
    public String deleteCategory(@PathVariable Long category_id){
        return categoryService.deleteCategory(category_id);
    }
}
