package com.ecommerce.controller;

import com.ecommerce.model.Order;
import com.ecommerce.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Order")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) { this.orderService = orderService; }

    @PostMapping
    public void createOrder(@RequestBody @Valid Order order) {

        orderService.registerOrder(order);
    }
    @GetMapping
    public List<Order> getOrders() {

        return orderService.searchAll();
    }
    @GetMapping(params = {"id"})
    public Optional<Order> getOrderById(@RequestParam("id") Long id) {

        return orderService.searchById(id);
    }
}
