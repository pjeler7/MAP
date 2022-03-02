package model;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class Cake implements Identifiable<Integer>, Serializable{
    private int ID;
    private String flavour;
    private float price;
    private int weight;

    public Cake() {
        this.ID = 0;
        this.flavour = "";
        this.price = 0;
        this.weight = 0;
    }

    public Cake(int ID, String flavour, float price, int weight) {
        this.ID = ID;
        this.flavour = flavour;
        this.price = price;
        this.weight = weight;
    }


    public String getFlavour() {
        return this.flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        String s = "";
        s = s + "Cake id: " + this.ID + ", ";
        s = s + this.flavour + " flavour ";
        s = s + this.price + " lei, ";
        s = s + this.weight + " grams";
        return s;
    }

    @Override
    public Integer getID() {
        return this.ID;
    }

    @Override
    public void setID(Integer id) {
        this.ID = id;
    }

}
