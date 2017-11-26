package com.th3pu1.ratatouilleapi.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="CATEGORY")
public class Category {

    @Id
    @GeneratedValue
    @Column(name="ID")
    private Long Id;

    @Column(name="NAME")
    private String name;

    @Column(name = "KITCHEN_ENABLED")
    private boolean kitchen_enabled;

    @Transient
    private List<Menu> menus;

    @Transient
    private List<Ingredient> ingredients;


    public void addIngredient(Ingredient ingredient){
        ingredient.setCategory(this);
        this.ingredients.add(ingredient);
    }

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    public List<Menu> getMenus(){
        return menus;
    }

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    public List<Ingredient> getIngredients(){
        return ingredients;
    }

}
