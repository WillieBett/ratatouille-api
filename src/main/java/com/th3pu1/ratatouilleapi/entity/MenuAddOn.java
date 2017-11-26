package com.th3pu1.ratatouilleapi.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Created by pchaivong on 9/9/2017 AD.
 */

/**
 * Many-to-Many relationship between Menu and Ingredients
 * For valid add-on items list that customer can make order.
 * Basically almost the same concept as `MenuDetail`
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "MENU_ADDONS")
public class MenuAddOn {

    @Id
    @GeneratedValue
    @Column(name="ID")
    private Long id;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "MENU",
        joinColumns = @JoinColumn(name = "MENU_ID"),
            inverseJoinColumns = @JoinColumn(name = "MENU_ADDON_ID")

    )
    private List<Menu> menus;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "INGREDIENT",
            joinColumns = @JoinColumn(name = "INGREDIENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "MENU_ADDON_ID")

    )
    private List<Menu> ingredients;

}
