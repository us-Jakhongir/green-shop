package uz.webbrain.appgreenshop.service.impl;

/*
 * project:  app-green-shop
 * author:   Jumanazar Said
 * created:  17/02/2022 1:25 PM
 */


import org.springframework.stereotype.Service;
import uz.webbrain.appgreenshop.dto.request.CategoryDTO;
import uz.webbrain.appgreenshop.entity.Category;
import uz.webbrain.appgreenshop.exception.NotFoundException;
import uz.webbrain.appgreenshop.repository.CategoryRespository;
import uz.webbrain.appgreenshop.service.CategoryService;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRespository categoryRespository;
    public CategoryServiceImpl(CategoryRespository categoryRespository){
        this.categoryRespository = categoryRespository;
    }

    @Override
    public Category addCategory(CategoryDTO categoryDTO) {
        Category newcategory = new Category();
        newcategory.setName(categoryDTO.getName());
        if(categoryDTO.getParentId() != null){
            Category parent = findById(categoryDTO.getParentId());
            if(parent != null){
                newcategory.setParent(parent);
            }
        }
        return categoryRespository.save(newcategory);
    }

    @Override
    public List<Category> findAll() {
        return categoryRespository.findAll();
    }

    @Override
    public Category editCategory(Long category_id, CategoryDTO categoryDTO) {
        Category categoryToBeUpdated = findById(category_id);
        if(categoryToBeUpdated == null){
            throw new NotFoundException("Category Not Found with id: {" + category_id + "}");
        }
        categoryToBeUpdated.setName(categoryDTO.getName());
        Category parent = findById(categoryDTO.getParentId());
        if(parent != null){
            categoryToBeUpdated.setParent(parent);
        }
        return categoryRespository.save(categoryToBeUpdated);
    }

    @Override
    public String deleteCategory(Long category_id) {
        String categoryname = "";
        Category categoryToBeDelete = findById(category_id);
        if(categoryToBeDelete == null){
            throw new NotFoundException("Category Not Found with id: {" + category_id + "}");
        }
        categoryname = categoryToBeDelete.getName();
        categoryRespository.delete(categoryToBeDelete);
        return "Category {" + categoryname+"} was successfully deleted";
    }

    @Override
    public Category findById(Long category_id) {
        Optional<Category> categoryOptional = categoryRespository.findById(category_id);
        return categoryOptional.orElse(null);
    }
}
