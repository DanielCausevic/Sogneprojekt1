package com.sogne.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Parish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int code;
    private String name;
    @ManyToOne
    @JoinColumn(name = "commune")
    private Commune commune;
    private double infectionPressure;
    private Date startOfLockdown;
    private Date closedTill;

    public Parish() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Commune getCommune() {
        return commune;
    }

    public void setCommune(Commune commune) {
        this.commune = commune;
    }

    public double getInfectionPressure() {
        return infectionPressure;
    }

    public void setInfectionPressure(double infectionPressure) {
        this.infectionPressure = infectionPressure;
    }

    public Date getStartOfLockdown() {
        return startOfLockdown;
    }

    public void setStartOfLockdown(Date startOfLockdown) {
        this.startOfLockdown = startOfLockdown;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public Parish(Long id, int code, String name, Commune commune, double infectionPressure, Date startOfLockdown) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.commune = commune;
        this.infectionPressure = infectionPressure;
        this.startOfLockdown = startOfLockdown;
    }
}
