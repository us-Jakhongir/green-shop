package uz.webbrain.appgreenshop.service;

import uz.webbrain.appgreenshop.dto.dto.request.CategoryDTO;
import uz.webbrain.appgreenshop.entity.Category;

import java.util.List;

public interface CategoryService {
    Category addCategory(CategoryDTO categoryDTO);
    List<Category> findAll();

    Category editCategory(Long category_id, CategoryDTO categoryDTO);
}
