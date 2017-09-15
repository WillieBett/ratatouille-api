package com.th3pu1.ratatouilleapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.th3pu1.ratatouilleapi.entity.Ingredient;
import lombok.*;
import org.springframework.boot.jackson.JsonComponent;

import java.math.BigDecimal;

/**
 * Created by pchaivong on 9/2/2017 AD.
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
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


    public IngredientResponse(Ingredient ingredient){
        this.id = ingredient.getId();
        this.name = ingredient.getName();
        this.price = ingredient.getPrice();
        this.costPerUnit = ingredient.getCostPerUnit();
    }
}
