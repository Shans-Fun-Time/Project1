package com.example.capstoneproject.groceries;

import jakarta.persistence.*;

@Entity
@Table(name = "groceries")
public class Groceries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false,unique = true,length = 60)
    private String product;
    @Column(nullable=false)
    private double price;
    @Column(length = 10, nullable = false)
    private String store;
    @Column(length = 10,nullable = false)
    private boolean bought;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public boolean isBought() {
        return bought;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }

    @Override
    public String toString() {
        return "Groceries{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", price=" + price +
                ", store='" + store + '\'' +
                ", bought=" + bought +
                '}';
    }
}


