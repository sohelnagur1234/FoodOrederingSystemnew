package com.project.fooderingnew.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import  com.project.fooderingnew.model.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
