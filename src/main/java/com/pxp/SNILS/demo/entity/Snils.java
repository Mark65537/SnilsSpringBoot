package com.pxp.SNILS.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Snils {

    @Id
    private int id;

    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Snils() {
    }

    public Snils(int id, String number) {
        this.id = id;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Snils{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
