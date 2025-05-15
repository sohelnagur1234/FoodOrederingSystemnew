package com.project.fooderingnew.model;


import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int foodId;

    private int quantity;

    private double totalPrice;

    // Constructors
    public OrderEntity() {}

    public OrderEntity(int foodId, int quantity, double totalPrice) {
        this.foodId = foodId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    // Getters and setters...
}
