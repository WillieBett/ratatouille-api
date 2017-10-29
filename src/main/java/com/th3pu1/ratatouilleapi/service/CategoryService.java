package com.th3pu1.ratatouilleapi.service;


import com.th3pu1.ratatouilleapi.entity.Category;
import com.th3pu1.ratatouilleapi.entity.Ingredient;
import com.th3pu1.ratatouilleapi.entity.Menu;
import com.th3pu1.ratatouilleapi.model.CategoryRequest;
import com.th3pu1.ratatouilleapi.model.CategoryResponse;
import com.th3pu1.ratatouilleapi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Get category detail by ID. Which could return empty() in case
     * the supplied `id` is invalid
     *
     * @param id
     * @return Optional\<CategoryResponse\>
     */
    public Optional<CategoryResponse> getCategoryDetail(Long id){
        Category category = categoryRepository.findOne(id);
        return serialized(category);
    }


    /**
     * Get list of all categories
     * @return
     */
    public List<CategoryResponse> getCategoryList(){
        ArrayList<CategoryResponse> items = new ArrayList<>();

        categoryRepository.findAll()
                .forEach(i -> {
                    Optional<CategoryResponse> resp = serialized(i);
                    if (resp.isPresent()){
                        items.add(resp.get());
                    }
                });

        return items;
    }


    /**
     * Add new Category
     * @param name
     * @param kitchenEnabled
     * @return
     */
    public Optional<CategoryResponse> addCategory(String name, boolean kitchenEnabled){
        Category category = new Category();
        category.setName(name);
        category.setKitchen_enabled(kitchenEnabled);

        Category saved = categoryRepository.save(category);
        return serialized(saved);
    }

    /**
     * Delete category
     * TODO: Might have to check if there is any reference from other related model to this or not.
     * @param id
     */
    public void deleteCategory(Long id){
        categoryRepository.delete(id);
    }


    /**
     * Update category information
     * @param id
     * @param request
     * @return
     */
    public Optional<CategoryResponse> updateCategory(Long id, CategoryRequest request){
        Category query = categoryRepository.findOne(id);
        if (query == null){
            return Optional.empty();
        }

        query.setName(request.getName());
        query.setKitchen_enabled(request.isKitchen_enabled());

        Category saved = categoryRepository.save(query);
        return serialized(saved);
    }

    /**
     * Serialized between Category entity and REST response to client application
     * in order to provide encapsulated internal implementation
     * @param category: Category entity
     * @return Optional\<CategoryResponse\>
     */
    private Optional<CategoryResponse> serialized(Category category){
        if (category.getClass() != Category.class)
            return Optional.empty();

        CategoryResponse resp = new CategoryResponse();
        resp.setId(category.getId());
        resp.setName(category.getName());
        resp.setKitchen_enabled(category.isKitchen_enabled());

        Set<Menu> menus = category.getMenus();
        if (menus==null){
            resp.setMenuItems(0);
        }
        else {
            resp.setMenuItems(menus.size());
        }

        Set<Ingredient> ingredients = category.getIngredients();
        if (ingredients == null){
            resp.setIngredientItems(0);
        }
        else {
            resp.setIngredientItems(ingredients.size());
        }

        return Optional.of(resp);
    }
}
