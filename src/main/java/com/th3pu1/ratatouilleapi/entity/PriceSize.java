package com.th3pu1.ratatouilleapi.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Each menu can have a few options depends on its size
 * And each size will have different price depends on
 * configuration
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "PRICE_SIZE")
@Entity
public class PriceSize {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;


    @Column(name = "SIZE")
    private String size;

    @Column(name = "PRICE")
    private BigDecimal price;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MENU_ID", referencedColumnName = "ID")
    private Menu menu;


}
