package com.th3pu1.ratatouilleapi.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by pchaivong on 9/3/2017 AD.
 */

@Entity
@Table(name="menu")
public class Menu {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long Id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;


    public Menu() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
