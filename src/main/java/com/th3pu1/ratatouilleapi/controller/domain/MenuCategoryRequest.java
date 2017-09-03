package com.th3pu1.ratatouilleapi.controller.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.jackson.JsonComponent;

/**
 * Created by pchaivong on 9/2/2017 AD.
 */

@JsonComponent
public class MenuCategoryRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    public MenuCategoryRequest() {
    }

    public MenuCategoryRequest(String name, String description) {
        this.name = name;
        this.description = description;
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

    @Override
    public String toString() {
        return "MenuCategoryRequest{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
