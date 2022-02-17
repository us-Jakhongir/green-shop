package uz.webbrain.appgreenshop.service.impl;

/*
 * project:  app-green-shop
 * author:   Jumanazar Said
 * created:  17/02/2022 1:25 PM
 */


import org.springframework.stereotype.Service;
import uz.webbrain.appgreenshop.dto.dto.request.CategoryDTO;
import uz.webbrain.appgreenshop.entity.Category;
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
            Category parent = null;
            Optional<Category> parentOption = categoryRespository.findById(categoryDTO.getParentId());
            if(parentOption.isPresent()){
                parent = parentOption.get();
                newcategory.setParent(parent);
            }
        }

        newcategory.setStatus(categoryDTO.getStatus());
        return categoryRespository.save(newcategory);
    }

    @Override
    public List<Category> findAll() {
        return categoryRespository.findAll();
    }

    @Override
    public Category editCategory(Long category_id, CategoryDTO categoryDTO) {
        return null;
    }
}
