package com.th3pu1.ratatouilleapi.entity;

import javax.persistence.*;

/**
 * Created by pchaivong on 9/9/2017 AD.
 */

@Entity
@Table(name = "menu_detail")
public class MenuDetail {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "menu_id")
    private long menu_id;

    @Column(name = "ingredient_id")
    private long ingredient_id;


    public MenuDetail() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(long menu_id) {
        this.menu_id = menu_id;
    }

    public long getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(long ingredient_id) {
        this.ingredient_id = ingredient_id;
    }
}
