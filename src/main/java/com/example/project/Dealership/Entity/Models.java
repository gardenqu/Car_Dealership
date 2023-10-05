package com.example.project.Dealership.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity(name="model")
public class Models {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Getter
    @Setter
    private int modelid;

    @ManyToOne
    @JoinColumn(name = "makeid")
    @Getter
    @Setter
    private Make make;


    @Column(nullable = false)
    @Getter
    @Setter
    private String modelname;

}
