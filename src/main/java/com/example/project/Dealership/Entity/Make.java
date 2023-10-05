package com.example.project.Dealership.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Make {


    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Getter
    @Setter
    private int makeid;

    @Column(nullable = false)
    @Getter
    @Setter
    private String make;


}
