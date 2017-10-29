package com.th3pu1.ratatouilleapi.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.boot.jackson.JsonComponent;

/**
 * Category request model, used for Create and Update category entity
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@JsonComponent
public class CategoryRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("kitchen-enabled")
    private boolean kitchen_enabled;
}
