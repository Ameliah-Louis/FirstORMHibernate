package com.hb.cda.firstjdbc.entity;

public class Skill {
    private Integer id;
    private String label;

// 3 Constructeur, pour s'adapter aux usages (un vide, un avec juste le label, in avec label ET id)
    public Skill() {
    }
    public Skill(String label) {
        this.label = label;
    }
    public Skill(Integer id, String label) {
        this.id = id;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }

}

