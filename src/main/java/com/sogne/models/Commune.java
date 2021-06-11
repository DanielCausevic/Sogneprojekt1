package com.sogne.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Commune {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double averageInfectionPressure;
    @OneToMany(mappedBy = "commune")
    private List<Parish> parish;

    public Commune() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAverageInfectionPressure() {
        return averageInfectionPressure;
    }

    public void setAverageInfectionPressure(double averageInfectionPressure) {
        this.averageInfectionPressure = averageInfectionPressure;
    }

    public Commune(String name, double averageInfectionPressure) {
        this.name = name;
        this.averageInfectionPressure = averageInfectionPressure;
    }
}
