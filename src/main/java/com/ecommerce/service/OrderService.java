package com.ecommerce.service;

import com.ecommerce.infra.repository.OrderRepository;
import com.ecommerce.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) { this.orderRepository = orderRepository; }

    public void registerOrder(Order order) {

        orderRepository.save(order);
    }
    public Optional<Order> searchById(Long id) {

        if(id == null) {

            throw new IllegalArgumentException("Id inválida!");
        }
        return orderRepository.findById(id);
    }
    public List<Order> searchAll() {

        return orderRepository.findAll();
    }
}
