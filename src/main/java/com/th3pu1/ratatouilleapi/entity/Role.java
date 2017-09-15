package com.th3pu1.ratatouilleapi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.lang.annotation.Documented;

/**
 * Created by pchaivong on 9/15/2017 AD.
 */

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "auth_roles")
public class Role {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Getter
    @Setter
    @Column(name = "name")
    private String roleName;
}
