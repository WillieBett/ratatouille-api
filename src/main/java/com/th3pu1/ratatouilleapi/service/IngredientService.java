package com.th3pu1.ratatouilleapi.service;

import com.th3pu1.ratatouilleapi.model.IngredientRequest;
import com.th3pu1.ratatouilleapi.entity.Ingredient;
import com.th3pu1.ratatouilleapi.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pchaivong on 9/2/2017 AD.
 */

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    public List<Ingredient> getAllIngredients(){
        List<Ingredient> ingredients = new ArrayList<>();

        ingredientRepository.findAll()
                .forEach(ingredients::add);

        return ingredients;
    }

    public void addIngredient(IngredientRequest request){
        Ingredient ingredient = new Ingredient();
        ingredient.setName(request.getName());
        ingredient.setPrice(request.getPrice());
        ingredient.setCostPerUnit(request.getCostPerUnit());

        ingredientRepository.save(ingredient);
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
}
