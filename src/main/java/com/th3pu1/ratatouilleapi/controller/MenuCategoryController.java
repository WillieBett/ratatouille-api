package com.th3pu1.ratatouilleapi.controller;

import com.th3pu1.ratatouilleapi.controller.domain.MenuCategoryRequest;
import com.th3pu1.ratatouilleapi.controller.domain.MenuCategoryResponse;
import com.th3pu1.ratatouilleapi.entity.MenuCategory;
import com.th3pu1.ratatouilleapi.service.MenuCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pchaivong on 9/2/2017 AD.
 */

@RestController
public class MenuCategoryController {

    @Autowired
    private MenuCategoryService menuCategoryService;


    @RequestMapping(value = "/menu-categories", method = RequestMethod.GET)
    public List<MenuCategoryResponse> listMenuCategories() {
        List<MenuCategoryResponse> items = new ArrayList<>();

        menuCategoryService.getMenuCategoryList()
                .forEach(entity -> {
                    MenuCategoryResponse resp = new MenuCategoryResponse(entity.getId(),
                            entity.getName(), entity.getDescription());
                    items.add(resp);
                });

        return items;
    }

    @RequestMapping(value = "/menu-categories", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED, code = HttpStatus.CREATED)
    public MenuCategoryResponse createMenuCategory(@RequestBody MenuCategoryRequest request){
        MenuCategory entity = new MenuCategory();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());

        MenuCategory ret = menuCategoryService.save(entity);
        return new MenuCategoryResponse(ret.getId(), ret.getName(), ret.getDescription());
    }
}
