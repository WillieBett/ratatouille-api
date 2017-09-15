package com.th3pu1.ratatouilleapi.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.boot.jackson.JsonComponent;

@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonComponent
public class RoleResponse extends RoleRequest{

    @JsonProperty("id")
    private Long id;
}
