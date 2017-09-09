package com.th3pu1.ratatouilleapi.service;

import com.th3pu1.ratatouilleapi.entity.Ingredient;
import com.th3pu1.ratatouilleapi.entity.Menu;
import com.th3pu1.ratatouilleapi.repository.IngredientRepository;
import com.th3pu1.ratatouilleapi.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by pchaivong on 9/3/2017 AD.
 */

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private IngredientRepository ingredientRepository;


    public Menu save(Menu menu){
        return menuRepository.save(menu);
    }

    public List<Menu> listMenu(){
        List<Menu> menus = new ArrayList<>();

        menuRepository.findAll().forEach(menus::add);
        return menus;
    }

    public Optional<Menu> getMenubyId(Long id){
        Menu item = menuRepository.findOne(id);
        if (item == null){
            return Optional.empty();
        }
        return Optional.of(menuRepository.findOne(id));
    }


    public void addIngredient(Menu menu, List<Long> ids){

        List<Ingredient> ingredients = new ArrayList<>();

        for (Long id: ids){
            Ingredient ingredient = ingredientRepository.findOne(id);
            if (ingredient != null){
                ingredients.add(ingredient);
            }
        }

        System.out.println("Add ingredients");

        menu.setIngredientList(ingredients);
    }

    public void addLegitimateTopping(Menu menu, List<Long> ids){
        List<Ingredient> toppings = new ArrayList<>();

        toppings = ids.stream()
                    .map(ingredientRepository::findOne)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());

        menu.setToppings(toppings);
    }
}
