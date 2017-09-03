package com.th3pu1.ratatouilleapi.controller.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.jackson.JsonComponent;

import java.math.BigDecimal;

/**
 * Created by pchaivong on 9/2/2017 AD.
 */

@JsonComponent
public class CreateIngredientRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("cost-per-unit")
    private BigDecimal costPerUnit;

    public CreateIngredientRequest() {
    }

    public CreateIngredientRequest(String name, BigDecimal price, BigDecimal costPerUnit) {
        this.name = name;
        this.price = price;
        this.costPerUnit = costPerUnit;
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
}
