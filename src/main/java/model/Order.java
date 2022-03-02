package model;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;
import java.io.StringReader;
import java.time.LocalDate;
import java.util.Date;

public class Order implements Identifiable<Integer>, Serializable {
    private int ID;
    private int cake;
    private float totalPrice;
    private LocalDate date;
    private String status;

    public Order() {
        this.ID = 0;
        this.cake = 0;
        this.date = null;
        this.totalPrice = 0;
        this.status = "";
    }

    public Order(int ID, int cake, float totalPrice, LocalDate date, String status) {
        this.ID = ID;
        this.cake = cake;
        this.totalPrice = totalPrice;
        this.date = date;
        this.status = status;
    }

    public int getCake() {
        return this.cake;
    }

    public void setCake(int cake) {
        this.cake = cake;
    }

    public float getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate d) {
        this.date = d;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status=status;
    }

    public Integer getID() {
        return this.ID;
    }

    public void setID(Integer id) {
        this.ID = id;
    }

    @Override
    public String toString() {
        String s = "";
        s = s + "Order ID: " + this.ID + " ";
        s = s + this.cake + ", ";
        s = s + this.totalPrice + " lei ";
        s = s + " until " + this.date;
        s = s + ", " + this.status;
        return s;
    }
}
