package com.th3pu1.ratatouilleapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.jackson.JsonComponent;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by pchaivong on 9/3/2017 AD.
 */

@NoArgsConstructor
@Getter
@Setter
@ToString
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
}
