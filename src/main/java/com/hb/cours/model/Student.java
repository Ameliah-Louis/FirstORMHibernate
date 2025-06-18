package com.hb.cours.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private Integer id;
    private String name;
    private String firstname;
    private LocalDate birthdate;
    private Promo promo;
    private List<Skill> skills = new ArrayList<>();


    public Student(String name, String firstname, LocalDate birthdate) {
        this.name = name;
        this.firstname = firstname;
        this.birthdate = birthdate;
    }
    public Student(Integer id, String name, String firstname, LocalDate birthdate) {
        this.id = id;
        this.name = name;
        this.firstname = firstname;
        this.birthdate = birthdate;
    }
    public Student() {
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFirstName() {
        return firstname;
    }
    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }
    public LocalDate getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
    public Promo getPromo() {
        return promo;
    }
    public void setPromo(Promo promo) {
        this.promo = promo;
    }
    public List<Skill> getSkills() {
        return skills;
    }
    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}
