package com.lab.CodeFellowship.Models;

import javax.persistence.*;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    private String name;


    @OneToOne(mappedBy = "role")
    private AppUser appUser;


    public Role(String name) {
        this.name = name;
    }

    public Role() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
