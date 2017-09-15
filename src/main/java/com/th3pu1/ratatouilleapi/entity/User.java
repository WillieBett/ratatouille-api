package com.th3pu1.ratatouilleapi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by pchaivong on 9/15/2017 AD.
 */
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "auth_user")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;


    @Column(name = "username")
    private String username;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "credential")
    private String credential;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;


}
