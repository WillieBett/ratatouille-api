package com.th3pu1.ratatouilleapi.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by pchaivong on 9/2/2017 AD.
 */

@Table(name = "ingredient")
@Entity
public class Ingredient {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private BigDecimal price;

    private BigDecimal costPerUnit;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="category_id", referencedColumnName="id")
    private Category category;


    public Ingredient() {
    }

    public Ingredient(long id, String name, BigDecimal price, BigDecimal costPerUnit) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.costPerUnit = costPerUnit;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public BigDecimal getCostPerUnit() {
        return costPerUnit;
    }

    public void setCostPerUnit(BigDecimal costPerUnit) {
        this.costPerUnit = costPerUnit;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", costPerUnit=" + costPerUnit +
                '}';
    }
}
