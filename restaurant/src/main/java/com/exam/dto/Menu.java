package com.exam.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String name;

    private int nuts;

    private int milk;

    public Menu(int id, String name, int nuts, int milk){
        this.setId(id);
        this.setName(name);
        this.setNuts(nuts);
        this.setMilk(milk);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNuts() {
        return nuts;
    }

    public void setNuts(int nuts) {
        this.nuts = nuts;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public String toString() {
        return "{ name: "+ getName() +
                " nuts: " + getNuts() +
                " milk: " + getMilk() + " }";
    }
}
