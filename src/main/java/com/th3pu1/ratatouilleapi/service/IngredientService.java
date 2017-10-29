package com.th3pu1.ratatouilleapi.service;

import com.th3pu1.ratatouilleapi.entity.Category;
import com.th3pu1.ratatouilleapi.model.IngredientRequest;
import com.th3pu1.ratatouilleapi.entity.Ingredient;
import com.th3pu1.ratatouilleapi.model.IngredientResponse;
import com.th3pu1.ratatouilleapi.repository.CategoryRepository;
import com.th3pu1.ratatouilleapi.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by pchaivong on 9/2/2017 AD.
 */

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Ingredient> getAllIngredients(){
        List<Ingredient> ingredients = new ArrayList<>();

        ingredientRepository.findAll()
                .forEach(ingredients::add);

        return ingredients;
    }

    public Optional<IngredientResponse> addIngredient(IngredientRequest request, Long categoryId){

        Category category = categoryRepository.findOne(categoryId);
        if (category == null){
            return Optional.empty();
        }

        Ingredient ingredient = serialized(request);
        category.addIngredient(ingredient);
        categoryRepository.save(category);

        return Optional.of(deserialized(ingredient));

    }

    /**
     * Get list of ingredient by specific category
     * @param categoryId
     * @return
     */
    public List<IngredientResponse> getIngredientsByCategory(Long categoryId){
        List<Ingredient> ingredients = ingredientRepository.findByCategory(categoryId);
        return ingredients.stream()
                .map(i -> deserialized(i))
                .collect(Collectors.toList());
    }

    public void deleteIngredient(Long id){
        ingredientRepository.delete(id);
    }

    public Ingredient getIngredient(Long id){
        return ingredientRepository.findOne(id);
    }

    public void updateIngredient(Ingredient ingredient){
        ingredientRepository.save(ingredient);
    }


    private Ingredient serialized(IngredientRequest request){
        Ingredient ingredient = new Ingredient();
        ingredient.setName(request.getName());
        ingredient.setPrice(request.getPrice());
        return ingredient;
    }

    private IngredientResponse deserialized(Ingredient ingredient){
        IngredientResponse response = new IngredientResponse();
        response.setId(ingredient.getId());
        response.setName(ingredient.getName());
        response.setCostPerUnit(ingredient.getCostPerUnit());
        response.setPrice(ingredient.getPrice());
        return response;
    }
}
