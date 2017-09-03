package com.th3pu1.ratatouilleapi.service;

import com.th3pu1.ratatouilleapi.entity.Menu;
import com.th3pu1.ratatouilleapi.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by pchaivong on 9/3/2017 AD.
 */

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;


    public Menu save(Menu menu){
        return menuRepository.save(menu);
    }

    public List<Menu> listMenu(){
        List<Menu> menus = new ArrayList<>();

        menuRepository.findAll().forEach(menus::add);
        return menus;
    }

    public Optional<Menu> getMenubyId(Long id){
        return Optional.of(menuRepository.findOne(id));
    }
}
