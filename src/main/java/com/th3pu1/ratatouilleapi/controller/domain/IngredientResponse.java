package com.th3pu1.ratatouilleapi.controller.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.th3pu1.ratatouilleapi.entity.Ingredient;
import org.springframework.boot.jackson.JsonComponent;

import java.math.BigDecimal;

/**
 * Created by pchaivong on 9/2/2017 AD.
 */

@JsonComponent
public class IngredientResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("cost-per-unit")
    private BigDecimal costPerUnit;


    public IngredientResponse() {
    }

    public IngredientResponse(Long id, String name, BigDecimal price, BigDecimal costPerUnit) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.costPerUnit = costPerUnit;
    }

    public IngredientResponse(Ingredient ingredient){
        this.id = ingredient.getId();
        this.name = ingredient.getName();
        this.price = ingredient.getPrice();
        this.costPerUnit = ingredient.getCostPerUnit();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public String toString() {
        return "IngredientResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", costPerUnit=" + costPerUnit +
                '}';
    }
}
