package com.project.fooderingnew.controller;


import com.project.fooderingnew.model.*;
import com.project.fooderingnew.repository.OrderRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class OrderController {

    private final OrderRepository orderRepo;

    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @PostMapping("/orders")
    public ResponseEntity<String> placeOrder(@RequestBody OrderRequest request) {
        // Static menu prices — you can replace this with DB lookup if needed
        MyFoodItem item = switch (request.getFoodId()) {
            case 1 -> new MyFoodItem(1, "Pizza", 12.99);
            case 2 -> new MyFoodItem(2, "Burger", 8.99);
            case 3 -> new MyFoodItem(3, "Pasta", 10.49);
            case 4 -> new MyFoodItem(4, "Salad", 11.49);
            default -> null;
        };

        if (item == null) {
            return ResponseEntity.badRequest().body("Invalid Food ID");
        }

        double total = item.getPrice() * request.getQuantity();

        // Save to DB
        OrderEntity order = new OrderEntity(item.getId(), request.getQuantity(), total);
        orderRepo.save(order);

        return ResponseEntity.ok("✅ Order placed for: " + item.getName() +
                                 " (Qty: " + request.getQuantity() +
                                 ") — Total: $" + total);
    }
}

