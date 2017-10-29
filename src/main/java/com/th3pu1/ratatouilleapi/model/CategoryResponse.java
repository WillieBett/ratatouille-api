package com.th3pu1.ratatouilleapi.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.boot.jackson.JsonComponent;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonComponent
public class CategoryResponse extends CategoryRequest{

    @JsonProperty("id")
    private Long id;

    @JsonProperty("menu-items")
    private int menuItems;

    @JsonProperty("ingredient-items")
    private int ingredientItems;
}
