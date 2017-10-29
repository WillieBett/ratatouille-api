package com.th3pu1.ratatouilleapi.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long Id;

    @Column(name="name")
    private String name;

    @Column(name = "kitchen_enabled")
    private boolean kitchen_enabled;

    /**
     * All menu in categories. One menu can be in only one category
     */
    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<Menu> menus;

    /**
     * All available ingredient for each category
     * This list will be used for create menu which will individually
     * Choose ingredients and addons from this list
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Ingredient> ingredients;

    public Category() {
    }

    public void addIngredient(Ingredient ingredient){
        ingredient.setCategory(this);
        this.ingredients.add(ingredient);
    }

    public void addMenu(Menu menu){

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isKitchen_enabled() {
        return kitchen_enabled;
    }

    public void setKitchen_enabled(boolean kitchen_enabled) {
        this.kitchen_enabled = kitchen_enabled;
    }

    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Category{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", kitchen_enabled=" + kitchen_enabled +
                '}';
    }
}
