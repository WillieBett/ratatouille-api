package com.th3pu1.ratatouilleapi.controller;

import com.th3pu1.ratatouilleapi.controller.domain.MenuRequest;
import com.th3pu1.ratatouilleapi.controller.domain.MenuResponse;
import com.th3pu1.ratatouilleapi.entity.Ingredient;
import com.th3pu1.ratatouilleapi.entity.Menu;
import com.th3pu1.ratatouilleapi.repository.IngredientRepository;
import com.th3pu1.ratatouilleapi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by pchaivong on 9/3/2017 AD.
 */

@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;


    /**
     * Get List of all available menu
     * @return List<MenuResponse>
     */
    @CrossOrigin("*")
    @RequestMapping(value = "/menus", method = RequestMethod.GET)
    public List<MenuResponse> listMenu(){
        List<MenuResponse> items = new ArrayList<>();

        menuService.listMenu().forEach(menu -> {
            MenuResponse response = new MenuResponse();
            response.setId(menu.getId());
            response.setName(menu.getName());
            response.setDescription(menu.getDescription());
            response.setPrice(menu.getPrice());
            response.setIngredients(menu.getIngredientList()
                                    .stream()
                                    .map(Ingredient::getId)
                                    .collect(Collectors.toList()));

            response.setToppings(menu.getToppings()
                                    .stream()
                                    .map(Ingredient::getId)
                                    .collect(Collectors.toList()));

            items.add(response);
        });

        return items;
    }


    /**
     * Create new menu configuration
     * @param request
     * @return
     */
    @CrossOrigin("*")
    @RequestMapping(value = "/menus", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED, code = HttpStatus.CREATED)
    public MenuResponse addMenu(@RequestBody MenuRequest request){
        Menu entity = new Menu();
        entity.setName(request.getName());
        entity.setPrice(request.getPrice());
        entity.setDescription(request.getDescription());


        /**
         * Add ingredients list for this menu.
         * It can be used to calculate cost and stock management
         * in the future.
         */
        menuService.addIngredient(entity, request.getIngredients());


        /**
         * Add legitimate toppings for this menu. This will be used when customer order the menu
         * And also be used in the cost calculation However, this ingredient is the same as use
         * main ingredient,So, they will share the same cost (Probably decompose this data model
         * in the future if it's needed
         */
        menuService.addLegitimateTopping(entity, request.getToppings());



        Menu result = menuService.save(entity);
        MenuResponse response = new MenuResponse();
        response.setId(result.getId());
        response.setName(result.getName());
        response.setPrice(result.getPrice());
        response.setDescription(result.getDescription());

        return response;
    }


    @CrossOrigin("*")
    @RequestMapping(value = "/menus/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK, code = HttpStatus.OK)
    public ResponseEntity<MenuResponse> getMenuDetail(@PathVariable Long id){
        Optional<Menu> optMenu = menuService.getMenubyId(id);

        return optMenu.map(menu -> {
                MenuResponse response = new MenuResponse();
                response.setId(menu.getId());
                response.setName(menu.getName());
                response.setDescription(menu.getDescription());
                return new ResponseEntity<MenuResponse>(response, HttpStatus.OK);
            })
                .orElseGet(() -> new ResponseEntity<MenuResponse>(HttpStatus.NOT_FOUND));


    }

}
