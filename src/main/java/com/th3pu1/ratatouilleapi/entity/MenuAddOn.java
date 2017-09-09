package com.th3pu1.ratatouilleapi.entity;

import javax.persistence.*;

/**
 * Created by pchaivong on 9/9/2017 AD.
 */

/**
 * Many-to-Many relationship between Menu and Ingredients
 * For valid add-on items list that customer can make order.
 * Basically almost the same concept as `MenuDetail`
 */
@Entity
@Table(name = "menu_addons")
public class MenuAddOn {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;


    @Column(name="menu_id")
    private Long menuId;

    @Column(name = "ingredient_id")
    private Long ingredientId;

    public MenuAddOn() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }
}
