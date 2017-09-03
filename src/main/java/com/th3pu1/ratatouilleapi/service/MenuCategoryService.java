package com.th3pu1.ratatouilleapi.service;

import com.th3pu1.ratatouilleapi.entity.MenuCategory;
import com.th3pu1.ratatouilleapi.repository.MenuCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pchaivong on 9/2/2017 AD.
 */

@Service
public class MenuCategoryService {

    @Autowired
    private MenuCategoryRepository menuCategoryRepository;



    public List<MenuCategory> getMenuCategoryList(){
        List<MenuCategory> items = new ArrayList<>();

        menuCategoryRepository.findAll()
                .forEach(items::add);

        return items;
    }

    public MenuCategory save(MenuCategory menuCategory){
        return menuCategoryRepository.save(menuCategory);
    }

    public MenuCategory getMenuCategoryById(Long id){
        return menuCategoryRepository.findOne(id);
    }

    public void deleteMenuCategory(Long id){
        menuCategoryRepository.delete(id);
    }
}
