package com.zerobase.demo.User;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class SiteUser {

    @Id
    @GeneratedValue(stategy = GenerationType.)
    private int id;

    @Column(unique = true)
    private String username;

    private String password;

    private String email;

    private String role;
}
