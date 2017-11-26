package com.th3pu1.ratatouilleapi.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pchaivong on 9/3/2017 AD.
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="MENU")
public class Menu {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long Id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;


    @ManyToOne(targetEntity = Category.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID", nullable = false)
    private Category category;


    @OneToMany(mappedBy = "menu")
    private List<PriceSize> sizes;



    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="MENU_DETAIL",
        joinColumns = @JoinColumn(name="MENU_ID"),
        inverseJoinColumns = @JoinColumn(name = "INGREDIENT_ID"))
    private List<Ingredient> ingredientList;

/*
    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "MENU_ADDONS",
            joinColumns = @JoinColumn(name = "MENU_ID"),
            inverseJoinColumns = @JoinColumn(name = "INGREDIENT_ID"))
    private List<Ingredient> toppings;

*/
}
