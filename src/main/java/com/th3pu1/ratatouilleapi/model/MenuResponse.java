package com.th3pu1.ratatouilleapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.jackson.JsonComponent;

/**
 * Created by pchaivong on 9/3/2017 AD.
 */

@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonComponent
public class MenuResponse extends MenuRequest{

    @JsonProperty("id")
    private Long id;

}
