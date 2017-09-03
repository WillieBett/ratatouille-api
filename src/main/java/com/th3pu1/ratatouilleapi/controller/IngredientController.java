package com.th3pu1.ratatouilleapi.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.th3pu1.ratatouilleapi.controller.domain.CreateIngredientRequest;
import com.th3pu1.ratatouilleapi.controller.domain.IngredientResponse;
import com.th3pu1.ratatouilleapi.entity.Ingredient;
import com.th3pu1.ratatouilleapi.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pchaivong on 9/2/2017 AD.
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
class ResourceNotFoundException extends RuntimeException {

    ResourceNotFoundException(String message){
        super(message);
    }

    ResourceNotFoundException(){
        super();
    }



    @Override
    public String toString() {
        return getMessage();
    }
}

@RestController
public class IngredientController {

    @Autowired
    IngredientService ingredientService;

    @RequestMapping(value = "/ingredients", method = RequestMethod.GET)
    public List<IngredientResponse> listIngredient(){
        List<IngredientResponse> items = new ArrayList<>();

        ingredientService.getAllIngredients()
                .forEach(ingredient -> {
                    IngredientResponse response = new IngredientResponse(ingredient.getId(),
                            ingredient.getName(),
                            ingredient.getPrice(),
                            ingredient.getCostPerUnit());
                    items.add(response);
                });
        return items;
    }

    @RequestMapping(value = "/ingredients", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED, code = HttpStatus.CREATED)
    public void createIngredient(@RequestBody CreateIngredientRequest request){
        ingredientService.addIngredient(request);
    }

    @RequestMapping(value = "/ingredients/{id}", method = RequestMethod.GET)
    public IngredientResponse getIngredient(@PathVariable Long id){
        Ingredient ingredient = ingredientService.getIngredient(id);
        if (ingredient != null){
            return new IngredientResponse(ingredient);
        }
        else {
            throw new ResourceNotFoundException();
        }
    }

    @RequestMapping(value = "/ingredients/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT, code = HttpStatus.NO_CONTENT)
    @Transactional
    public void updateIngredient(@PathVariable Long id, @RequestBody CreateIngredientRequest request){
        Ingredient ingredient = ingredientService.getIngredient(id);
        if(ingredient!=null){
            if (request.getName() != null)
                ingredient.setName(request.getName());

            if (request.getPrice() != null)
                ingredient.setPrice(request.getPrice());

            if (request.getCostPerUnit() != null)
                ingredient.setCostPerUnit(request.getCostPerUnit());


            ingredientService.updateIngredient(ingredient);
        }
        else {
            throw new ResourceNotFoundException();
        }
    }

    @RequestMapping(value = "/ingredients/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT, code = HttpStatus.NO_CONTENT)
    public void deleteIngredient(@PathVariable Long id){
        Ingredient ingredient = ingredientService.getIngredient(id);
        if (ingredient!=null){
            ingredientService.deleteIngredient(id);
        }
        else {
            throw new ResourceNotFoundException("Ingredient not found");
        }
    }

}
