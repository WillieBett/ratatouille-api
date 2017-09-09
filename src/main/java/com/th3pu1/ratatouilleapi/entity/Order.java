package com.th3pu1.ratatouilleapi.entity;

import javax.persistence.*;

/**
 * Created by pchaivong on 9/9/2017 AD.
 */

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "table")
    private String table;

}
