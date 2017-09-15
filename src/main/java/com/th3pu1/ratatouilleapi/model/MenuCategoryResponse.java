package com.th3pu1.ratatouilleapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.boot.jackson.JsonComponent;

/**
 * Created by pchaivong on 9/2/2017 AD.
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@JsonComponent
public class MenuCategoryResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

}
