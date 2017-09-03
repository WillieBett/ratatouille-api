package com.th3pu1.ratatouilleapi.controller;

import com.th3pu1.ratatouilleapi.controller.domain.MenuRequest;
import com.th3pu1.ratatouilleapi.controller.domain.MenuResponse;
import com.th3pu1.ratatouilleapi.entity.Menu;
import com.th3pu1.ratatouilleapi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pchaivong on 9/3/2017 AD.
 */

@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;


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
            items.add(response);
        });

        return items;
    }


    @CrossOrigin("*")
    @RequestMapping(value = "/menus", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED, code = HttpStatus.CREATED)
    public MenuResponse addMenu(@RequestBody MenuRequest request){
        Menu entity = new Menu();
        entity.setName(request.getName());
        entity.setPrice(request.getPrice());
        entity.setDescription(request.getDescription());

        Menu result = menuService.save(entity);
        MenuResponse response = new MenuResponse();
        response.setId(result.getId());
        response.setName(result.getName());
        response.setPrice(result.getPrice());
        response.setDescription(result.getDescription());

        return response;
    }
}
