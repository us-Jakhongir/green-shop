package uz.webbrain.appgreenshop.service;

/*
 * project:  app-green-shop
 * author:   Jumanazar Said
 * created:  17/02/2022 1:25 PM
 */

import uz.webbrain.appgreenshop.dto.request.CategoryDTO;
import uz.webbrain.appgreenshop.entity.Category;

import java.util.List;

public interface CategoryService {
    Category addCategory(CategoryDTO categoryDTO);

    List<Category> findAll();

    Category editCategory(Long category_id, CategoryDTO categoryDTO);

    String deleteCategory(Long category_id);

    Category findById(Long category_id);
}
