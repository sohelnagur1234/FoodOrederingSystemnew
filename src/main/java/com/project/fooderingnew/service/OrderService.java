package com.project.fooderingnew.service;


import com.project.fooderingnew.model.MyFoodItem;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class OrderService {

    private List<MyFoodItem> menu = Arrays.asList(
            new MyFoodItem(1, "Pizza", 12.99),
            new MyFoodItem(2, "Burger", 8.99),
            new MyFoodItem(3, "Pasta", 10.49),
            new MyFoodItem(4, "Salad", 11.49)
    );

    public MyFoodItem getItemById(int id) {
        return menu.stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
