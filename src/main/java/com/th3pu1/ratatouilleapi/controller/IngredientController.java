package com.th3pu1.ratatouilleapi.controller;

import com.th3pu1.ratatouilleapi.model.IngredientRequest;
import com.th3pu1.ratatouilleapi.model.IngredientResponse;
import com.th3pu1.ratatouilleapi.entity.Ingredient;
import com.th3pu1.ratatouilleapi.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.th3pu1.ratatouilleapi.controller.exception.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by pchaivong on 9/2/2017 AD.
 */



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


    /**
     * Create ingredient by specific category
     *
     * @param id
     * @param request
     * @return
     */
    @CrossOrigin("*")
    @RequestMapping(value = "/api/categories/{id}/ingredients", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED, code = HttpStatus.CREATED)
    public IngredientResponse createIngredient(@PathVariable Long id,
                                               @RequestBody IngredientRequest request){

        Optional<IngredientResponse> response = ingredientService.addIngredient(request, id);
        return response.orElseThrow(ResourceNotFoundException::new);
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/api/categories/{id}/ingredients", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK, code = HttpStatus.OK)
    public List<IngredientResponse> getIngredientList(@PathVariable Long id){
        return ingredientService.getIngredientsByCategory(id);
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


    @CrossOrigin("*")
    @RequestMapping(value = "/api/ingredients/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT, code = HttpStatus.NO_CONTENT)
    @Transactional
    public void updateIngredient(@PathVariable Long id, @RequestBody IngredientRequest request){
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


    @CrossOrigin("*")
    @RequestMapping(value = "/api/ingredients/{id}", method = RequestMethod.DELETE)
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
