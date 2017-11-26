package com.th3pu1.ratatouilleapi.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PriceSize {

    @JsonProperty("size")
    private String size;

    @JsonProperty("price")
    private BigDecimal price;

}
