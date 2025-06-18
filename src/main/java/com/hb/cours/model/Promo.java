package com.hb.cours.model;

import java.time.LocalDate;

public class Promo {

    private Integer id;
    private String name;
    private LocalDate startDate;
    private Integer duration;
    public Promo(String name, LocalDate startDate, Integer duration) {
        this.name = name;
        this.startDate = startDate;
        this.duration = duration;
    }
    public Promo(Integer id, String name, LocalDate startDate, Integer duration) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.duration = duration;
    }
    public Promo() {
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
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public Integer getDuration() {
        return duration;
    }
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     * Calcul de la date de fin de la promo en ajoutant la durée au startDate.
     */
    public LocalDate getEndDate() {
        return (startDate != null && duration != null)
                ? startDate.plusDays(duration)
                : null;
    }

}
