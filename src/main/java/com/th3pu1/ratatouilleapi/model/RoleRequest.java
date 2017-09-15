package com.th3pu1.ratatouilleapi.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.jackson.JsonComponent;

@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonComponent
public class RoleRequest {

    @JsonProperty("name")
    private String name;

}
