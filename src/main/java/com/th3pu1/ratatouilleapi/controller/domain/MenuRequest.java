package com.th3pu1.ratatouilleapi.controller.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.jackson.JsonComponent;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by pchaivong on 9/3/2017 AD.
 */

@JsonComponent
public class MenuRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("ingredients")
    private List<Long> ingredients;

    @JsonProperty("toppings")
    private List<Long> toppings;

    public MenuRequest() {
    }


    public List<Long> getToppings() {
        return toppings;
    }

    public void setToppings(List<Long> toppings) {
        this.toppings = toppings;
    }

    public List<Long> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Long> ingredients) {
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
